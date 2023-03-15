package com.first.maptest.accompaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.fragment.Fragment3;
import com.first.maptest.moretab.MvInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

//이동지원 예약
public class rv extends Fragment {

    String date;
    String time;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public static rv newInstance()
    {
        return new rv();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.rv, container, false);

        //완료버튼
        Button cp = rootView.findViewById(R.id.cp);
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                done1 done1 = new done1();
                fragmentTransaction.replace(R.id.mainframe, done1);
                fragmentTransaction.commit();

                String Ad = ((EditText)rootView.findViewById(R.id.Mvtext)).getText().toString();
                String message = (Ad+"으로 목적지 설정되었습니다.");

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                if(getArguments()!=null){
                    date = getArguments().getString("date");
                    time = getArguments().getString("time");
                }
                String address = Ad;


                if(date.length()>0&&time.length()>0&&Ad.length()>0){
                    FirebaseUser rv = FirebaseAuth.getInstance().getCurrentUser();
                    //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    //Firestore의 인스턴스 초기화

                    MvInfo mvInfo = new MvInfo(date, time, Ad);
                    if(rv != null){
                        db.collection("MV").document(rv.getUid()).set(mvInfo)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        //startToast("예약내역 전달에 성공했습니다.");
                                        //finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // startToast("예약내역 전달에 실패했습니다.");
                                    }
                                });
                    }

                }else{
                    //startToast("예약 해주세요.");
                }
            }
        });

        return rootView;
    }
}
