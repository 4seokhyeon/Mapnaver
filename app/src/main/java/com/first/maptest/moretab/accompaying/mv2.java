package com.first.maptest.moretab.accompaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.moretab.MvInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class mv2 extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DocumentReference docuser = db.collection("Users").document(Uid);

    String date, time, ad;
    TextView tv_name, tv_date, tv_time, tv_ad;
    private DataSnapshot mDatabase;

    public static mv2 newInstance()
    {
        return new mv2();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mv2, container, false);


        tv_date = (TextView) rootView.findViewById(R.id.tv_date);
        tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        tv_ad = (TextView) rootView.findViewById(R.id.tv_ad);
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);

        if(getArguments()!=null) {
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            ad = getArguments().getString("ad");

            tv_date.setText(date);
            tv_time.setText(time);
            tv_ad.setText(ad);
        }

        /*db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Log.d(TAG, document.getId() + "=>" + document.getString("name"));
                                String name = document.getString("name");
                                tv_name.setText(name);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });*/

        docuser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String name = documentSnapshot.getString("name");

                tv_name.setText(name);
            }
        });

        if(date.length()>0&&time.length()>0&&ad.length()>0){
            FirebaseUser mv = FirebaseAuth.getInstance().getCurrentUser();
            //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            //Firestore의 인스턴스 초기화

            MvInfo mvinfo = new MvInfo(date, time, ad);
            if(mv != null){
                db.collection("MV").document(mv.getUid()).set(mvinfo)
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
            //startToast("회원정보를 입력해주세요.");
        }


        Button end = rootView.findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                mv3 mv3 = new mv3();
                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("ad",ad);
                mv3.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainframe, mv3);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }

}

