package com.first.maptest.moretab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.first.maptest.R;


public class reserve2 extends Fragment {

    EditText input;
    Button next;
    private Activity rootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setContentView(int activity_main) {
    }



}
