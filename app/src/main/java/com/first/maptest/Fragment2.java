package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
//예약 프래그 먼 한나가 해보렴 여기다가 자유롭게
public class Fragment2 extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}
