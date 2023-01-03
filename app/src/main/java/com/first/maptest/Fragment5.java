package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
//더보기 탭 프래그먼트 최현지 멍청한놈아 왜 프로젝트를 지우고 난리?
public class Fragment5 extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_5, container, false);
    }
}
