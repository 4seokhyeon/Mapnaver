package com.first.maptest.accompaying;

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
import com.first.maptest.fragment.Fragment1;

public class hp3 extends Fragment{

    String date, time, ps;
    TextView tv_date1, tv_time1, tv_ps;

    public static hp3 newInstance() {
        return new hp3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.hp3, container, false);

        tv_date1 = (TextView) rootView.findViewById(R.id.tv_date1);
        tv_time1 = (TextView) rootView.findViewById(R.id.tv_time1);
        tv_ps = (TextView) rootView.findViewById(R.id.tv_ps);

        if(getArguments()!=null) {
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            ps = getArguments().getString("ps");

            tv_date1.setText(date);
            tv_time1.setText(time);
            tv_ps.setText(ps);
        }

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
