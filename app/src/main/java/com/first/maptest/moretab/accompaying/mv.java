package com.first.maptest.moretab.accompaying;

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
import com.first.maptest.fragment.Fragment3;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//이동지원
public class mv extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public static mv newInstance() {
        return new mv();
    }

    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;

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

        //예약버튼
        Button r1 = (Button) rootView.findViewById(R.id.rv);
        r1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                rv rv = new rv();
                fragmentTransaction.replace(R.id.mainframe, rv);
                fragmentTransaction.commit();

                String year = Integer.toString(dPicker.getYear());
                String month = Integer.toString(1+dPicker.getMonth());
                String day = Integer.toString(dPicker.getDayOfMonth());
                String hour = Integer.toString(tPicker.getCurrentHour());
                String minute = Integer.toString(tPicker.getCurrentMinute());
                String message = (year+"년 "+month+"월 "+day+"일 "+hour+"시 "+minute+"분으로 예약되었습니다.");

                String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+" : "+minute);


                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                rv.setArguments(bundle);

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();
            }
        });

        rdoCal = (RadioButton) rootView.findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) rootView.findViewById(R.id.rdoTime);

        dPicker = (DatePicker) rootView.findViewById(R.id.datePicker1);
        tPicker = (TimePicker) rootView.findViewById(R.id.timePicker1);

        dPicker.setVisibility(View.VISIBLE);
        tPicker.setVisibility(View.INVISIBLE);
        rdoCal.setChecked(true);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
                rdoTime.setChecked(false);
                rdoCal.setChecked(true);
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
