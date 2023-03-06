/*package com.first.maptest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.first.maptest.moretab.MvInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.common.net.InternetDomainName;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class mvinfo extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    DatePicker dPicker;
    TimePicker tPicker;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mv);

        findViewById(R.id.rv).setOnClickListener(onClickListener);
    }

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.rv:
                    profileUpdate();
                    break;
            }
        }
    };

    private void profileUpdate(){

        String year = Integer.toString(dPicker.getYear());
        String month = Integer.toString(1+dPicker.getMonth());
        String day = Integer.toString(dPicker.getDayOfMonth());
        String hour = Integer.toString(tPicker.getCurrentHour());
        String minute = Integer.toString(tPicker.getCurrentMinute());

        String date = (year+month+day);
        String time = (hour+minute);

        if(date.length()>0&&time.length()>0){
            FirebaseUser mv = FirebaseAuth.getInstance().getCurrentUser();
            //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            //Firestore의 인스턴스 초기화

            MvInfo mvinfo = new MvInfo(date, time);
            if(mv != null){
                db.collection("MV").document(mv.getUid()).set(mvinfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("예약내역 전달에 성공했습니다.");
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("예약내역 전달에 실패했습니다.");
                            }
                        });
            }


        }else{
            startToast("예약 해주세요.");
        }

    }
    private void startToast(String msg){
        Toast.makeText(this, msg,
                Toast.LENGTH_SHORT).show();

    }
}
*/
