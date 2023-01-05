package com.first.maptest;

//더보기탭

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

//버튼 누르면 화면전환 하는거 + 회원정보 나오는거 해야함

public class Fragment5 extends Fragment {
    MainActivity activity;

    private View view;
    private Button review;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_5, container, false);

        review = view.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                review review  = new review();
                transaction.replace(R.id.item_fragment5,review);
                transaction.commit();
            }
        });

        return view;
    }
}
