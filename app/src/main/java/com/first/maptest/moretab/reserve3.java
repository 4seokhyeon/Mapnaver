package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;


public class reserve3 extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    String date;
    String time, name, number, input, birthday, hname;
    TextView tv_date, tv_time;
    TextView tv_name1, tv_number1, tv_input1, tv_birthday,tv_hname;
    private DataSnapshot mDatabase;

    /*private TextView content;
    private EditText input;
    private Button next;

    DatebaseReference mRootRef = FirebaseDatebase.getIn

     */


    public static reserve3 newInstance()
    {
        return new reserve3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve3, container, false);


        tv_date = (TextView) rootView.findViewById(R.id.tv_date);
        tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        tv_name1 = (TextView) rootView.findViewById(R.id.tv_name1);
        tv_number1 = (TextView) rootView.findViewById(R.id.tv_number1);
        tv_input1 = (TextView) rootView.findViewById(R.id.tv_input1);
        tv_birthday = (TextView) rootView.findViewById(R.id.tv_birthday1);
        tv_hname = (TextView) rootView.findViewById(R.id.tv_hname1);


        if(getArguments()!=null){
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            name = getArguments().getString("name");
            number = getArguments().getString("number");
            input = getArguments().getString("input");
            birthday = getArguments().getString("birthday");
            hname = getArguments().getString("hname");

            tv_date.setText(date);
            tv_time.setText(time);
            tv_name1.setText(name);
            tv_number1.setText(number);
            tv_input1.setText(input);
            tv_birthday.setText(birthday);
            tv_hname.setText(hname);

            if(date.length()>0&&time.length()>0&&name.length()>0&&number.length()>0&&input.length()>0&&birthday.length()>0&&hname.length()>0){
                FirebaseUser reserve3 = FirebaseAuth.getInstance().getCurrentUser();
                //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                //Firestore의 인스턴스 초기화

                confirmdata confirmdata = new confirmdata(date, time, name, number, input, birthday, hname);
                if(reserve3 != null){
                    db.collection("confirm").document(reserve3.getUid()).set(confirmdata)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    //startToast("회원정보 등록에 성공했습니다.");
                                    //finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    //startToast("회원정보 등록에 실패했습니다.");
                                }
                            });
                }
            }else{
                //startToast("회원정보를 입력해주세요.");
            }
        }

        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .remove(reserve3.this) // 현재 프래그먼트 제거
                        .commit();

                day day = new day();
                fragmentManager.beginTransaction()
                        .add(R.id.subFrame, day) // 새로운 프래그먼트 추가
                        .commit();
            }
        });


        Button end = rootView.findViewById(R.id.end1);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
                end end = new end();
                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("name",name);
                bundle.putString("hname",hname);
                end.setArguments(bundle);
                reserve23 reserve23 = new reserve23();
                fragmentManager.beginTransaction()
                        .replace(R.id.subFrame,end) // Replace "mainframe" with the ID of the container where you want to show the reserve23 fragment
                        .commit();
            }
        });


/*
        mDatabase.child("users").child(name).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        }); */

        return rootView;
    }

}

