package com.first.maptest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.accompaying.mv;
import com.first.maptest.accompaying.hp;

//동행 서비스 탭
public class Fragment3 extends Fragment {

    public static Fragment3 newInstance() {
        return new Fragment3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //예약버튼
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_3, container, false);

        Button mv = rootView.findViewById(R.id.mv);
        mv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                mv mv = new mv();
                fragmentTransaction.replace(R.id.mainframe, mv);
                fragmentTransaction.commit();
            }
        });

        Button hp = rootView.findViewById(R.id.hp);
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                hp hp = new hp();
                fragmentTransaction.replace(R.id.mainframe, hp);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
