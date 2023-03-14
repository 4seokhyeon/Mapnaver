package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;

public class confirm extends Fragment {


//day 에서 가져올 변수

    TextView tvYear3, tvMonth3, tvDay3, tvHour3, tvMinute3;
    Button btnConfirm;
    private View tv_date;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.confirm, container, false);

/*
        tv_date = rootView.findViewById(R.id.tv_date);

        if(getArguments()!=null){
            String date = getArguments().getString("date");
            String time = getArguments().getString("time");

        }

        setContentView(R.layout.confirm);
        setTitle("레스토랑 자리 예약 확정");
        */

        //예약 날 정보
        //이전 day 변수들


        //메인 액티비티로 이동해 정보 수정 가능 back기능
        Button btnReturn = rootView.findViewById(R.id.BtnReturnToTable);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                reserve23 reserve23 = new reserve23();
                fragmentTransaction.replace(R.id.mainframe, reserve23);
                fragmentTransaction.commit();
            }
        });

        /*
        //두번째 액티비티의 화면 동작 설계
        //이전 화면 정보 뿌리기
        tvName2 = (TextView) rootView.findViewById(R.id.tvName2);
        tvPhone2 = (TextView)rootView.findViewById(R.id.tvPhone2);
        seat2 = (TextView)rootView.findViewById(R.id.Seat2);
        personnel2 = (TextView)rootView.findViewById(R.id.Personnel2);

        //앞의 MainActivity 의 정보 받아오기
        //context로 액티비티 전체를 받아와 이전에 저장된 텍스트 변수의 텍스트를 가져옴
        tvName2.setText(((TableActivity)TableActivity.tableContext).tvName.getText());
        tvPhone2.setText(((TableActivity)TableActivity.tableContext).tvPhone.getText());
        seat2.setText(((TableActivity)TableActivity.tableContext).seat.getText());
        personnel2.setText(((TableActivity)TableActivity.tableContext).personnel.getText());



        Button btnConfirm = (Button) rootView.findViewById(R.id.BtnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(confirm.this );
                dlg.setTitle("예약 확정");
                dlg.setMessage("정말 예약을 확정하시겠습니까?");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getApplicationContext(),"예약 확정 되었습니다.\n 완료 버튼을 누르세요",
                                Toast.LENGTH_SHORT).show();
                        //다음 페이지에서 인사 멘트로 끝내기??-예약해주셔서 감사합니다. 몇월 몇날 몇시 좌석으로 모시겠습니다.

                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity().getApplicationContext(),"취소했습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show(); //

            }
        }); 


        Button btnFinish = (Button) rootView.findViewById(R.id.BtnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent
                Intent intent = new Intent(confirm() ,EndActivity.class);
                startActivity(intent);//다음 액티비티 화면에 출력
            }
        }); */


        return rootView;
    }
}

