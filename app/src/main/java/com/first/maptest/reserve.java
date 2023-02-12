package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.fragment.Fragment2;
import com.first.maptest.moretab.day;

//예약탭
public class reserve extends Fragment {

    public static reserve newInstance()
    {
        return new reserve();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve, container, false);

        Button back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction.replace(R.id.mainframe, fragment2);
                fragmentTransaction.commit();
            }
        });

        Button day = rootView.findViewById(R.id.day);
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                day day = new day();
                fragmentTransaction.replace(R.id.mainframe, day);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
