package com.first.maptest.accompaying;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.fragment.Fragment3;

import java.util.Calendar;

//이동지원
public class mv extends Fragment {

    public static mv newInstance() {
        return new mv();
    }

    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mv, container, false);

        Button back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                fragmentTransaction.replace(R.id.mainframe, fragment3);
                fragmentTransaction.commit();
            }
        });

        tvYear = (TextView) rootView.findViewById(R.id.tvYear);
        tvMonth = (TextView) rootView.findViewById(R.id.tvMonth);
        tvDay = (TextView) rootView.findViewById(R.id.tvDay);
        tvHour =  (TextView) rootView.findViewById(R.id.tvHour);
        tvMinute =  (TextView) rootView.findViewById(R.id.tvMinute);

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });

        //예약버튼
        Button r1 = rootView.findViewById(R.id.rv);
        r1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                rv rv = new rv();
                fragmentTransaction.replace(R.id.mainframe, rv);
                fragmentTransaction.commit();

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(calView.getDate());

                tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
                tvMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
                tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));
                tvHour.setText(Integer.toString(tPicker.getHour()));
                tvMinute.setText(Integer.toString(tPicker.getMinute()));

            }
        });

        rdoCal = rootView.findViewById(R.id.rdoCal);
        rdoTime = rootView.findViewById(R.id.rdoTime);

        calView = rootView.findViewById(R.id.calendarView1);
        tPicker = rootView.findViewById(R.id.timePicker1);

        calView.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calView.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
            }
        });

        /*calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
            }
        });*/

        /*java.util.Calendar curDate = java.util.Calendar.getInstance();
        curDate.setTimeInMillis(calView.getDate());

        tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
        tvMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
        tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));
        tvHour.setText(Integer.toString(tPicker.getHour()));
        tvMinute.setText(Integer.toString(tPicker.getMinute()));*/

        return rootView;
    }
}
