package com.first.maptest.accompaying;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.UserInfo;
import com.first.maptest.fragment.Fragment3;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

//병원동행
public class hp extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    public static hp newInstance() {
        return new hp();
    }

    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.hp, container, false);

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
        Button r2 = rootView.findViewById(R.id.rv2);
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                rv2 rv2 = new rv2();
                fragmentTransaction.replace(R.id.mainframe, rv2);
                fragmentTransaction.commit();

                String year = Integer.toString(dPicker.getYear());
                String month = Integer.toString(1+dPicker.getMonth());
                String day = Integer.toString(dPicker.getDayOfMonth());
                String hour = Integer.toString(tPicker.getCurrentHour());
                String minute = Integer.toString(tPicker.getCurrentMinute());
                String message = (year+"년 "+month+"월 "+day+"일 "+hour+"시 "+minute+"분으로 예약되었습니다.");

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+" : "+minute);

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                if(date.length()>0&&time.length()>0){
                    FirebaseUser hp = FirebaseAuth.getInstance().getCurrentUser();
                    //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    //Firestore의 인스턴스 초기화

                    HpInfo hpinfo = new HpInfo(date, time);
                    if(hp != null){
                        db.collection("Hp").document(hp.getUid()).set(hpinfo)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        //startToast("회원정보 등록에 성공했습니다.");
                                        //finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //startToast("회원정보 등록에 실패했습니다.");
                                    }
                                });
                    }
                }else{
                    //startToast("회원정보를 입력해주세요.");
                }
            }
        });

        rdoCal = (RadioButton) rootView.findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) rootView.findViewById(R.id.rdoTime);

        dPicker = (DatePicker) rootView.findViewById(R.id.datePicker1);
        tPicker = (TimePicker) rootView.findViewById(R.id.timePicker1);

        dPicker.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                rdoCal.setChecked(true);
                rdoTime.setChecked(false);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
                rdoCal.setChecked(false);
                rdoTime.setChecked(true);
            }
        });

        return rootView;
    }
}
