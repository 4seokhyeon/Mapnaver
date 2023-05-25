package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.reserve;

public class reserve2 extends Fragment {

    public static reserve2 newInstance(){
        return new reserve2();
    }


    EditText edtname, edtnumber, edtinput, edtbirthday;
    String hname;
    TextView tv_h_name, tv_hname;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    //뒤로
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve2, container, false);



        tv_hname = (TextView) rootView.findViewById(R.id.tv_hname);

        if(getArguments()!=null){
            hname = getArguments().getString("hname");
            tv_hname.setText(hname);
        }


        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve reserve = new reserve();
                fragmentTransaction.replace(R.id.subFrame, reserve);
                fragmentTransaction.commit();

            }
        });

        //정보 입력 후 다음 페이지
        Button reserve23 = rootView.findViewById(R.id.reserve23);
        reserve23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                edtname = rootView.findViewById(R.id.edtname);
                edtnumber = rootView.findViewById(R.id.edtnumber);
                edtinput = rootView.findViewById(R.id.edtinput);
                edtbirthday = rootView.findViewById(R.id.edtbirthday);
                /*tv_h_name = rootView.findViewById(R.id.tv_h_name); */


                /*
                //연락처 입력시 하이픈(-) 자동입력
                edtnumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
*/
                String name = edtname.getText().toString();
                String number = edtnumber.getText().toString();
                String input = edtinput.getText().toString();
                String birthday = edtbirthday.getText().toString();
                /*String hname = tv_h_name.getText().toString();
                /*String message = (name+number+input+"분으로 예약되었습니다.");

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show(); */

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.reserve23 reserve23 = new reserve23();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("number",number);
                bundle.putString("input",input);
                bundle.putString("birthday",birthday);
                bundle.putString("hname",hname);
                reserve23.setArguments(bundle);
                fragmentTransaction.replace(R.id.subFrame, reserve23);
                fragmentTransaction.commit();

            }

        });



        return rootView;
    }

}



/*
        Button reserve23 = (Button) rootView.findViewById(R.id.reserve23);
        reserve23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve23 reserve23 = new reserve23();
                fragmentTransaction.replace(R.id.mainframe, reserve23);
                fragmentTransaction.commit();
            }
        }); */