package com.first.maptest.moretab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;


public class day extends Fragment {

    public static Object dayContext;

    public static com.first.maptest.accompaying.mv newInstance() {
        return new com.first.maptest.accompaying.mv();
    }

    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    String name,number,input;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.day, container, false);

        if(getArguments()!=null){
            name = getArguments().getString("name");
            number = getArguments().getString("number");
            input = getArguments().getString("input");
        }

        Button back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve23 reserve23 = new reserve23();
                fragmentTransaction.replace(R.id.mainframe, reserve23);
                fragmentTransaction.commit();
            }
        });

        //예약버튼
        Button rv = (Button) rootView.findViewById(R.id.rv);
        rv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {


                //mDatabase.child("users").child(userId).setValue(user);

                String year = Integer.toString(dPicker.getYear());
                String month = Integer.toString(1+dPicker.getMonth());
                String day = Integer.toString(dPicker.getDayOfMonth());
                String hour = Integer.toString(tPicker.getCurrentHour());
                String minute = Integer.toString(tPicker.getCurrentMinute());
                String message = (year+"년 "+month+"월 "+day+"일 "+hour+"시 "+minute+"분으로 예약되었습니다.");

                String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+"시 "+minute+"분");

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve3 reserve3 = new reserve3();
                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("name",name);
                bundle.putString("number",number);
                bundle.putString("input",input);
                reserve3.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainframe, reserve3);
                fragmentTransaction.commit();


              /*  String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+" : "+minute);


                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                reserve3.setArguments(bundle);

                fragmentTransaction.replace(R.id.mainframe,reserve3);
                fragmentTransaction.commit(); */


                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();
            }
        });

        rdoCal = (RadioButton) rootView.findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) rootView.findViewById(R.id.rdoTime);

        dPicker = (DatePicker) rootView.findViewById(R.id.datePicker1);
        tPicker = (TimePicker) rootView.findViewById(R.id.timePicker1);

        /*tvYear = (TextView) rootView.findViewById(R.id.tvYear);
        tvMonth = (TextView) rootView.findViewById(R.id.tvMonth);
        tvDay = (TextView) rootView.findViewById(R.id.tvDay);
        tvHour =  (TextView) rootView.findViewById(R.id.tvHour);
        tvMinute =  (TextView) rootView.findViewById(R.id.tvMinute); */

        dPicker.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);


        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                rdoCal.setChecked(true);
                rdoTime.setChecked(false);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
                rdoCal.setChecked(false);
                rdoTime.setChecked(true);
            }
        });

        return rootView;
    }
}
