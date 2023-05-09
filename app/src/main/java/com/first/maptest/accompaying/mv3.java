package com.first.maptest.accompaying;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
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
import com.first.maptest.fragment.Fragment1;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class mv3 extends Fragment{

    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    String date, time, ad, name;
    TextView tv_date1, tv_time1, tv_ad, tv_name;


    public static mv3 newInstance() {
        return new mv3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mv3, container, false);

        tv_date1 = (TextView) rootView.findViewById(R.id.tv_date1);
        tv_time1 = (TextView) rootView.findViewById(R.id.tv_time1);
        tv_ad = (TextView) rootView.findViewById(R.id.tv_ad);
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);


        if(getArguments()!=null) {
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            ad = getArguments().getString("ad");

            tv_date1.setText(date);
            tv_time1.setText(time);
            tv_ad.setText(ad);
        }

        db.collection("Users")
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
                });

        //완료버튼
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.replace(R.id.mainframe, fragment1);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}