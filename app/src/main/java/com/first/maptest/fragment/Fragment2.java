package com.first.maptest.fragment;

/*import java.util.Calender*/;

import android.os.Bundle;
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


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.reserve;

import java.util.zip.Inflater;

//예약 프래그 먼 한나가 해보렴 여기다가 자유롭게 할때 커밋 푸쉬 주석 생활화 하셔
public class Fragment2 extends Fragment {

    //예약버튼!
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
        //예약버튼
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_2, container, false);

        Button reserve = rootView.findViewById(R.id.reserve);
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve reserve = new reserve();
                fragmentTransaction.replace(R.id.mainframe, reserve);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
