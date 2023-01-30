package com.first.maptest;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemberInfoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        findViewById(R.id.CheckButton).setOnClickListener(onClickListener);
    }

    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.CheckButton:
                    profileUpdate();
                    break;
            }
        }
    };

    private void profileUpdate(){

        String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
        String p_num = ((EditText)findViewById(R.id.phonenumberEditText)).getText().toString();
        String birthday = ((EditText)findViewById(R.id.birthDayEditText)).getText().toString();
        String addr = ((EditText)findViewById(R.id.addressEditText)).getText().toString();

        if(name.length()>0&&p_num.length()>9&&birthday.length()==8&&addr.length()>0){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            //user = 회원의 고유 id라고 생각하면됨 _ 파이어베이스에서 회원을 식별하기 위함.
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            //Firestore의 인스턴스 초기화

            UserInfo uinfo = new UserInfo(name, p_num,birthday,addr);
            if(user != null){
                db.collection("Users").document(user.getUid()).set(uinfo)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startToast("회원정보 등록에 성공했습니다.");
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                startToast("회원정보 등록에 실패했습니다.");
                            }
                        });
            }


        }else{
            startToast("회원정보를 입력해주세요.");
        }

        }
        private void startToast(String msg){
            Toast.makeText(this, msg,
                    Toast.LENGTH_SHORT).show();

    }
}
