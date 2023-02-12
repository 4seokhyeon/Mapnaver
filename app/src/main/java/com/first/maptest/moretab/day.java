package com.first.maptest.moretab;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.first.maptest.R;


public class day extends Fragment {
    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    public static void setOnClickListener(View.OnClickListener onClickListener) {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.day, container, false);



            /*Button reserve2 = rootView.findViewById(R.id.reserve2);
            reserve2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    reserve2 reserve2  = new reserve2();
                    fragmentTransaction.replace(R.id.mainframe, reserve2);
                    fragmentTransaction.commit();

                    java.util.Calendar curDate = java.util.Calendar.getInstance();
                    curDate.setTimeInMillis(calView.getDate());

                }
            }); */

            btnStart = rootView.findViewById(R.id.Start);
            btnEnd = rootView.findViewById(R.id.reserve2);

            chrono = rootView.findViewById(R.id.chronometer);

            rdoCal = rootView.findViewById(R.id.rdoCal);
            rdoTime = rootView.findViewById(R.id.rdoTime);

            tPicker = rootView.findViewById(R.id.timePicker1);
            calView = rootView.findViewById(R.id.calendarView1);

            tvYear = (TextView) rootView.findViewById(R.id.tvYear);
            tvMonth = (TextView) rootView.findViewById(R.id.tvMonth);
            tvDay = (TextView) rootView.findViewById(R.id.tvDay);
            tvHour = (TextView) rootView.findViewById(R.id.tvHour);
            tvMinute = (TextView) rootView.findViewById(R.id.tvMinute);

            tPicker.setVisibility(View.INVISIBLE);
            calView.setVisibility(View.INVISIBLE);

            rdoCal.setOnClickListener(v -> {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            });


            rdoTime.setOnClickListener(v -> {
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            });

            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                    chrono.setTextColor(Color.RED);
                }
            });

            btnEnd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chrono.stop();
                    tvYear.setText(Integer.toString(selectYear));
                    tvMonth.setText(Integer.toString(selectMonth));
                    tvDay.setText(Integer.toString(selectDay));

                    tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                    tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                    chrono.setTextColor(Color.BLUE);
                }
            });

            calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                @Override
                public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                    selectYear = year;
                    selectMonth = month + 1;
                    selectDay = dayOfMonth;
                }
            });


            return rootView;


        }

    }
