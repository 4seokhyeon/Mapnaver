package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;

public class reserve23 extends Fragment {

    String name,number,input,birthday;


    public static reserve23 newInstance()
    {
        return new reserve23();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve23, container, false);



        if(getArguments()!=null){
            name = getArguments().getString("name");
            number = getArguments().getString("number");
            input = getArguments().getString("input");
            birthday = getArguments().getString("birthday");
        }


        Button back2 = rootView.findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve2 reserve2 = new reserve2();
                fragmentTransaction.replace(R.id.mainframe, reserve2);
                fragmentTransaction.commit();
            }
        });

        Button day = rootView.findViewById(R.id.day);
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                day day = new day();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("number",number);
                bundle.putString("input",input);
                bundle.putString("birthday",birthday);
                day.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainframe, day);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }


}

