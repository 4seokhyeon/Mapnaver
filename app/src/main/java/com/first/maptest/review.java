package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
public class review extends Fragment {

    MainActivity activity;

    public static review newInstance() {
        return new review();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.review,container,false);

        activity = (MainActivity) getActivity();

        View view = inflater.inflate(R.layout.review,null);
        return view;

    }
}