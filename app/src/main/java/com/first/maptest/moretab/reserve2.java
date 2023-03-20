package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.reserve;

public class reserve2 extends Fragment {

    public static reserve2 newInstance(){
        return new reserve2();
    }


    EditText edtname, edtnumber, edtinput;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    //뒤로
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.reserve2, container, false);

        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve reserve = new reserve();
                fragmentTransaction.replace(R.id.mainframe, reserve);
                fragmentTransaction.commit();


            }
        });

        //정보 입력 후 다음 페이지
        Button reserve23 = rootView.findViewById(R.id.reserve23);
        reserve23.setOnClickListener(new View.OnClickListener() {
            private View dialogView;

            @Override
            public void onClick(View v) {


                edtname = rootView.findViewById(R.id.edtname);
                edtnumber = rootView.findViewById(R.id.edtnumber);
                edtinput = rootView.findViewById(R.id.edtinput);

                /*
                //연락처 입력시 하이픈(-) 자동입력
                edtnumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
                */

                String name = edtname.getText().toString();
                String number = edtnumber.getText().toString();
                String input = edtinput.getText().toString();
                /*String message = (name+number+input+"분으로 예약되었습니다.");

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show(); */

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.reserve23 reserve23 = new reserve23();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("number",number);
                bundle.putString("input",input);
                reserve23.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainframe, reserve23);
                fragmentTransaction.commit();


                //dialog1.xml 파일 인플레이트
                /* dialogView = (View) View.inflate(reserve2.this, R.layout.dialog, null);
                //alertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(reserve2.this);
                dlg.setTitle("예약자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView); //인플레이트한 것을 대화상자로 사용

                //setPositiveButton
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                                EditText dlgEdtPhone = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                                 tvName.setText(dlgEdtName.getText().toString());
                                tvPhone.setText(dlgEdtPhone.getText().toString());
                                Toast.makeText(getApplicationContext(),"예약자 정보 확인했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        });


                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity().getApplicationContext(),"취소했습니다.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show(); */ //가장 중요! dialog창 보이기
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