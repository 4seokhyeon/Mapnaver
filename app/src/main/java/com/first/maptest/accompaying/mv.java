package com.first.maptest.accompaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.fragment.Fragment3;

//이동지원
public class mv extends Fragment {

    public static mv newInstance() {
        return new mv();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.mv, container, false);

        Button back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                fragmentTransaction.replace(R.id.mainframe, fragment3);
                fragmentTransaction.commit();
            }
        });

        //예약버튼
        Button r1 = rootView.findViewById(R.id.rv);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                rv rv = new rv();
                fragmentTransaction.replace(R.id.mainframe, rv);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
