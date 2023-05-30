package com.first.maptest.moretab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.MainActivity;
import com.first.maptest.R;
import com.first.maptest.fragment.Fragment1;

public class end extends Fragment{

    String date;
    String time, name, hname;
    TextView tv_date1, tv_time1, tv_name2,tv_hname2, tv_hname;


    public static end newInstance() {
        return new end();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.end, container, false);

        tv_date1 = (TextView) rootView.findViewById(R.id.tv_date1);
        tv_time1 = (TextView) rootView.findViewById(R.id.tv_time1);
        tv_name2 = (TextView) rootView.findViewById(R.id.tv_name2);
        tv_hname2 = (TextView) rootView.findViewById(R.id.tv_hname2);


        if(getArguments()!=null) {
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            name = getArguments().getString("name");
            hname = getArguments().getString("hname");

            tv_date1.setText(date);
            tv_time1.setText(time);
            tv_name2.setText(name);
            tv_hname2.setText(hname);
        }



        //완료버튼
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}//


