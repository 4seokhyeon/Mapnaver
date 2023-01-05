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

//버튼 누르면 화면전환 하는거 + 회원정보 나오는거 해야함

public class Fragment5 extends Fragment {

    public static Fragment5 newInstance() {
        return new Fragment5();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5,null);
        Button review = (Button) view.findViewById(R.id.review);

        /*review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(com.first.maptest.review.newInstance());
            }
        });*/

        return view;
    }
}
