package com.first.maptest.moretab.accompaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;

//이동지원 예약
public class rv extends Fragment {

    public static rv newInstance()
    {
        return new rv();
    }

    String date, time;
    EditText AD;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.rv, container, false);

        if(getArguments()!=null){
            date = getArguments().getString("date");
            time = getArguments().getString("time");
        }

        //완료버튼
        Button cp = rootView.findViewById(R.id.cp);
        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                mv2 mv2 = new mv2();
                fragmentTransaction.replace(R.id.mainframe, mv2);
                fragmentTransaction.commit();

                AD = rootView.findViewById(R.id.Mvtext);
                String ad = AD.getText().toString();

                String message = (ad+"으로 목적지 설정되었습니다.");
                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("ad",ad);
                mv2.setArguments(bundle);
            }
        });

        return rootView;
    }
}
