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


import androidx.fragment.app.Fragment;

import com.first.maptest.R;

//예약 프래그 먼 한나가 해보렴 여기다가 자유롭게 할때 커밋 푸쉬 주석 생활화 하셔
public class Fragment2 extends Fragment {

    //
   /*  Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal,rdoTime;
    CalendarView calender;
    TimePicker time;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    @override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = (Chronometer)findViewById(R.id.chronometer1);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);
        calendar = (CalendarView)findViewById(R.id.calendarView1);
        time = (TimePicker)findViewById(R.id.timePicker1);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView)findViewById(R.id.tvMinute);

        calendar.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.setVisibility(View.INVISIBLE);
                time.setVisibility(View.VISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                java.util.Calendar curDate = java.util.Calendar.getInstance();
                curDate.setTimeInMillis(calendar.getDate());
                tvYear.setText(Integer.toString(curDate.get(Calendar.YEAR)));
                tvMonth.setText(Integer.toString(curDate.get(Calendar.MONTH)));
                tvDay.setText(Integer.toString(curDate.get(Calendar.DATE)));

                tvHour.setText(Integer.toString(time.getCurrentHour()));
                tvMinute.setText(Integer.toString(time.getCurrentMinute()));
            }
        }); 일단 날짜 시간 창*/

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}
