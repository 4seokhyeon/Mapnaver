package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class reserve3 extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    String date;
    String time, name, number, input;
    TextView tv_date, tv_time;
    TextView tv_name1, tv_number1,tv_input1;
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


        if(getArguments()!=null){
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            name = getArguments().getString("name");
            number = getArguments().getString("number");
            input = getArguments().getString("input");

            tv_date.setText(date);
            tv_time.setText(time);
            tv_name1.setText(name);
            tv_number1.setText(number);
            tv_input1.setText(input);
        }

        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                day day = new day();
                fragmentTransaction.replace(R.id.mainframe, day);
                fragmentTransaction.commit();
            }
        });


        Button confirm = rootView.findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                confirm confirm = new confirm();
                fragmentTransaction.replace(R.id.mainframe, confirm);
                fragmentTransaction.commit();

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

