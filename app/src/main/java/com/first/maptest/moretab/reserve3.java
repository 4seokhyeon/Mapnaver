package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;


public class reserve3 extends Fragment {

    /*private TextView content;
    private EditText input;
    private Button next;

    DatebaseReference mRootRef = FirebaseDatebase.getIn

     */

    public static reserve3 newInstance()
    {
        return new reserve3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve3, container, false);

        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                day day = new day();
                fragmentTransaction.replace(R.id.mainframe, day);
                fragmentTransaction.commit();
            }
        });

        Button confirm = rootView.findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                confirm confirm = new confirm();
                fragmentTransaction.replace(R.id.mainframe, confirm);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

    /* EditText input;
    Button next;
    private Activity rootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setContentView(int activity_main) {
    } */


}
