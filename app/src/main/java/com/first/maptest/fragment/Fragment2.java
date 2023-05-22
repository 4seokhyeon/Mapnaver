package com.first.maptest.fragment;



import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.reserve;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.zip.Inflater;

//예약 탭
public class Fragment2 extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    TextView mv_date, mv_time, mv_ad, mv_name, hp_name, hp_ps, hp_time, hp_date;

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

        db.collection("Users")
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
                });

        db.collection("MV")
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

        db.collection("Hp")
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
                });

        return rootView;
    }
}
