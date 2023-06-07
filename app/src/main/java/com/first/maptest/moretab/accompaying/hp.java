package com.first.maptest.moretab.accompaying;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.fragment.Fragment3;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Field;

//병원동행
public class hp extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static hp newInstance() {
        return new hp();
    }

    RadioButton rdoCal, rdoTime, cdBtn, male, female, age1, age2, age3;
    RadioGroup gender, age;
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
                String month = Integer.toString(1 + dPicker.getMonth());
                String day = Integer.toString(dPicker.getDayOfMonth());
                String hour = Integer.toString(tPicker.getCurrentHour());
                String minute = Integer.toString(tPicker.getCurrentMinute());
                String message = (year + "년 " + month + "월 " + day + "일 " + hour + "시 " + minute + "분으로 예약되었습니다.");

                /*String gender = null;
                if (male.isChecked()) {
                    gender = male.getText().toString();
                } else if (female.isChecked()) {
                    gender = female.getText().toString();
                }

                String age = null;
                if(age1.isChecked()){
                    age = age1.getText().toString();
                } else if(age2.isChecked()){
                    age = age2.getText().toString();
                } else if(age3.isChecked()){
                    age = age3.getText().toString();
                }

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+" : "+minute);

                String[] str = {"사석현","이상엽","최현지","박한나","아무개","홍길동"};

                Random rd = new Random();
                int r = rd.nextInt(str.length);
                String ps = str[r];*/

                String[] str = {"사석현","이상엽","최현지","박한나","아무개","홍길동"};
                String Mname = null;
                String gender = null;
                String age = null;

                if(male.isChecked() && age1.isChecked()){
                    gender = male.getText().toString();
                    age = age1.getText().toString();
                    Mname = str[1];
                }else if(male.isChecked() && age2.isChecked()){
                    gender = male.getText().toString();
                    age = age2.getText().toString();
                    Mname = str[0];
                }else if(male.isChecked() && age3.isChecked()){
                    gender = male.getText().toString();
                    age = age3.getText().toString();
                    Mname = str[5];
                }else if(female.isChecked() && age1.isChecked()){
                    gender = female.getText().toString();
                    age = age1.getText().toString();
                    Mname = str[3];
                }else if(female.isChecked() && age2.isChecked()){
                    gender = female.getText().toString();
                    age = age2.getText().toString();
                    Mname = str[2];
                }
                else if(female.isChecked() && age3.isChecked()){
                    gender = female.getText().toString();
                    age = age3.getText().toString();
                    Mname = str[4];
                }

                Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT).show();

                String date = (year+"년 "+month+"월 "+day+"일");
                String time = (hour+" : "+minute);

                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("Mname",Mname);
                rv2.setArguments(bundle);

                if(date.length()>0&&time.length()>0&&gender.length()>0&&age.length()>0&&Mname.length()>0){
                    FirebaseUser hp = FirebaseAuth.getInstance().getCurrentUser();
                    //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    //Firestore의 인스턴스 초기화

                    HpInfo hpinfo = new HpInfo(date, time, gender, age, Mname);
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

        cdBtn = (RadioButton) rootView.findViewById(R.id.cdBtn);
        gender = (RadioGroup) rootView.findViewById(R.id.gender);
        male = (RadioButton) rootView.findViewById(R.id.male);
        female = (RadioButton) rootView.findViewById(R.id.female);
        age = (RadioGroup) rootView.findViewById(R.id.age);
        age1 = (RadioButton) rootView.findViewById(R.id.age1);
        age2 = (RadioButton) rootView.findViewById(R.id.age2);
        age3 = (RadioButton) rootView.findViewById(R.id.age3);

        dPicker = (DatePicker) rootView.findViewById(R.id.datePicker1);
        tPicker = (TimePicker) rootView.findViewById(R.id.timePicker1);

        dPicker.setVisibility(View.VISIBLE);
        rdoCal.setChecked(true);
        tPicker.setVisibility(View.INVISIBLE);
        gender.setVisibility(View.INVISIBLE);
        age.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.VISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                gender.setVisibility(View.INVISIBLE);
                age.setVisibility(View.INVISIBLE);
                rdoCal.setChecked(true);
                rdoTime.setChecked(false);
                cdBtn.setChecked(false);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.VISIBLE);
                gender.setVisibility(View.INVISIBLE);
                age.setVisibility(View.INVISIBLE);
                rdoCal.setChecked(false);
                rdoTime.setChecked(true);
                cdBtn.setChecked(false);
            }
        });

        cdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                gender.setVisibility(View.VISIBLE);
                age.setVisibility(View.VISIBLE);
                rdoCal.setChecked(false);
                rdoTime.setChecked(false);
                cdBtn.setChecked(true);
            }
        });

        return rootView;
    }

    }
