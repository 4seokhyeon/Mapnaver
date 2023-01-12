package com.first.maptest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.Listframent;
import com.first.maptest.MainActivity;
import com.first.maptest.R;
import com.first.maptest.moretab.customer;
import com.first.maptest.moretab.my;
import com.first.maptest.moretab.notice;
import com.first.maptest.moretab.pop;
import com.first.maptest.moretab.review;

//더보기탭
public class Fragment5 extends Fragment {

    public static Fragment5 newInstance()
    {
        return new Fragment5();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_5, container, false);

        Button my = rootView.findViewById(R.id.my);
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                my my = new my();
                fragmentTransaction.replace(R.id.mainframe, my);
                fragmentTransaction.commit();
            }
        });

        Button review = rootView.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                review review = new review();
                fragmentTransaction.replace(R.id.mainframe, review);
                fragmentTransaction.commit();
            }
        });

        Button pop = rootView.findViewById(R.id.pop);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                pop pop = new pop();
                fragmentTransaction.replace(R.id.mainframe, pop);
                fragmentTransaction.commit();
            }
        });

        Button customer = rootView.findViewById(R.id.customer);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                customer customer = new customer();
                fragmentTransaction.replace(R.id.mainframe, customer);
                fragmentTransaction.commit();
            }
        });

        Button notice = rootView.findViewById(R.id.notice);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                notice notice = new notice();
                fragmentTransaction.replace(R.id.mainframe, notice);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
