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
    MainActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity=(MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_5,container,false);

        Button review = rootView.findViewById(R.id.review);
        Button pop = rootView.findViewById(R.id.pop);
        Button customer = rootView.findViewById(R.id.customer);
        Button notice = rootView.findViewById(R.id.notice);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onFragmentChange(1);
            }
        });

        return rootView;
    }
}
