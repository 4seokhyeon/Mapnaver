package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.fragment.Fragment5;

public class review extends Fragment {


    private View view;
    private Button back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.review,container,false);

        /*activity = (MainActivity) getActivity();*/


        view = inflater.inflate(R.layout.review, container, false);

        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment5 fragment5 = new Fragment5();
                transaction.replace(R.id.review, fragment5);
                transaction.commit();
            }
        });

        return view;
    }
}