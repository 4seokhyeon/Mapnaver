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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

//예약 탭
public class Fragment2 extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private TextView mv_date, mv_time, mv_ad, mv_name, hp_name, hp_ps, hp_time, hp_date;
    private TextView tv_name1, tv_date, tv_time, tv_hname;

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2, container, false);

        mv_date = rootView.findViewById(R.id.mv_date);
        mv_time = rootView.findViewById(R.id.mv_time);
        mv_ad = rootView.findViewById(R.id.mv_ad);
        mv_name = rootView.findViewById(R.id.mv_name);
        hp_name = rootView.findViewById(R.id.hp_name);
        hp_ps = rootView.findViewById(R.id.hp_ps);
        hp_date = rootView.findViewById(R.id.hp_date);
        hp_time = rootView.findViewById(R.id.hp_time);
        tv_name1 = rootView.findViewById(R.id.tv_name1);
        tv_date = rootView.findViewById(R.id.tv_date);
        tv_hname = rootView.findViewById(R.id.tv_hname);
        tv_time = rootView.findViewById(R.id.tv_time);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            DocumentReference docuser = db.collection("Users").document(uid);
            DocumentReference docmv = db.collection("MV").document(uid);
            DocumentReference dochp = db.collection("Hp").document(uid);
            DocumentReference docconfirm = db.collection("confirm").document(uid);

            docuser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String name = documentSnapshot.getString("name");
                    mv_name.setText("이름: " + name);
                    hp_name.setText("이름: " + name);
                }
            });

            docmv.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String ad = documentSnapshot.getString("ad");
                    String date = documentSnapshot.getString("date");
                    String time = documentSnapshot.getString("time");
                    mv_ad.setText("목적지: " + ad);
                    mv_date.setText("예약날짜: " + date);
                    mv_time.setText("예약시간: " + time);
                }
            });

            dochp.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String ps = documentSnapshot.getString("ps");
                    String date = documentSnapshot.getString("date");
                    String time = documentSnapshot.getString("time");
                    hp_ps.setText("매니저: " + ps);
                    hp_date.setText("예약날짜: " + date);
                    hp_time.setText("예약시간: " + time);
                }
            });

            docconfirm.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    String name = documentSnapshot.getString("name");
                    String date = documentSnapshot.getString("date");
                    String time = documentSnapshot.getString("time");
                    String hname = documentSnapshot.getString("hname");
                    tv_name1.setText("이름: " + name);
                    tv_date.setText("예약날짜: " + date);
                    tv_time.setText("예약시간: " + time);
                    tv_hname.setText("예약한 병원: " + hname);
                }
            });
        }

        return rootView;
    }
}