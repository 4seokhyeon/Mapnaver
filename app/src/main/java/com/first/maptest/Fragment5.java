package com.first.maptest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
               // review.setVisibility(View.VISIBLE);
                activity.onFragmentChange(1);
            }
        });

        /*pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.setVisibility(View.VISIBLE);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customer.setVisibility(View.VISIBLE);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility(View.VISIBLE);
            }
        });*/

        return rootView;
    }
}
