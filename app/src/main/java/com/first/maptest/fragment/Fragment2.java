package com.first.maptest.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.first.maptest.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

//예약 탭
public class Fragment2 extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DocumentReference docuser = db.collection("Users").document(Uid);
    DocumentReference docmv = db.collection("MV").document(Uid);
    DocumentReference dochp = db.collection("Hp").document(Uid);
    DocumentReference docconfirm = db.collection("confirm").document(Uid);


    TextView mv_date, mv_time, mv_ad, mv_name, hp_name, hp_ps, hp_time, hp_date;
    TextView tv_name1, tv_date, tv_time, tv_hname;


    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2, container, false);

        mv_date = (TextView) rootView.findViewById(R.id.mv_date);
        mv_time = (TextView) rootView.findViewById(R.id.mv_time);
        mv_ad = (TextView) rootView.findViewById(R.id.mv_ad);
        mv_name = (TextView) rootView.findViewById(R.id.mv_name);
        hp_name = (TextView) rootView.findViewById(R.id.hp_name);
        hp_ps = (TextView) rootView.findViewById(R.id.hp_ps);
        hp_date = (TextView) rootView.findViewById(R.id.hp_date);
        hp_time = (TextView) rootView.findViewById(R.id.hp_time);
        tv_name1 = (TextView) rootView.findViewById(R.id.tv_name1);
        tv_date = (TextView) rootView.findViewById(R.id.tv_date);
        tv_hname = (TextView) rootView.findViewById(R.id.tv_hname);
        tv_time = (TextView) rootView.findViewById(R.id.tv_time);


        docuser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //City city = documentSnapshot.toObject(City.class);
                String name = documentSnapshot.getString("name");

                mv_name.setText(name);
                hp_name.setText(name);
            }
        });
        /* db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String name = document.getString("name");
                                mv_name.setText("이름: "+name);
                                hp_name.setText("이름: "+name);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });*/

        docmv.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //City city = documentSnapshot.toObject(City.class);
                String ad = documentSnapshot.getString("ad");
                String date = documentSnapshot.getString("date");
                String time = documentSnapshot.getString("time");
                mv_ad.setText("목적지: "+ad);
                mv_date.setText("예약날짜: "+date);
                mv_time.setText("예약시간: "+time);
            }
        });

       /* db.collection("MV")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String ad = document.getString("ad");
                                String date = document.getString("date");
                                String time = document.getString("time");
                                mv_ad.setText("목적지: "+ad);
                                mv_date.setText("예약날짜: "+date);
                                mv_time.setText("예약시간: "+time);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });
*/

        dochp.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //City city = documentSnapshot.toObject(City.class);
                String ps = documentSnapshot.getString("ps");
                String date = documentSnapshot.getString("date");
                String time = documentSnapshot.getString("time");
                hp_ps.setText("매니저: "+ps);
                hp_date.setText("예약날짜: "+date);
                hp_time.setText("예약시간: "+time);
            }
        });

        /*db.collection("Hp")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String ps = document.getString("ps");
                                String date = document.getString("date");
                                String time = document.getString("time");
                                hp_ps.setText("매니저: "+ps);
                                hp_date.setText("예약날짜: "+date);
                                hp_time.setText("예약시간: "+time);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });*/

        docconfirm.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                //City city = documentSnapshot.toObject(City.class);
                String name = documentSnapshot.getString("name");
                String date = documentSnapshot.getString("date");
                String time = documentSnapshot.getString("time");
                String hname = documentSnapshot.getString("hname");
                tv_name1.setText(name);
                tv_date.setText("예약날짜: "+date);
                tv_time.setText("예약시간: "+time);
                tv_hname.setText("예약한 병원: "+hname);
            }
        });

        return rootView;
    }
}

/*
        db.collection("confirm")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String name = document.getString("name");
                                String date = document.getString("date");
                                String time = document.getString("time");
                                String hname = document.getString("hname");
                                tv_name1.setText(name);
                                tv_date.setText("예약날짜: "+date);
                                tv_time.setText("예약시간: "+time);
                                tv_hname.setText(hname);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });
*/

