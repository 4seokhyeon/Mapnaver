package com.cloudtest.kakaomap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.LoginButton).setOnClickListener(onClickListener);
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void onBackPressed(){
        super.onBackPressed();
        MystartActivity(LoginActivity.class);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.LoginButton:
                    signUp();
                    break;
            }
        }
    };

    private void signUp(){

        String email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.passwordCheckEditText)).getText().toString();

        if(email.length()>0&&password.length()>0&&passwordCheck.length()>0){
            if(password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("회원가입에 성공했습니다.");
                                    MystartActivity(LoginActivity.class);

                                    //성공했을 때 UI로직
                                } else {
                                    if(task.getException()!=null) {
                                        startToast(task.getException().toString());
                                    }
                                    //실패했을 때 UI로직
                                }
                            }
                        });
            }else{
                startToast("비밀번호가 일치하지 않습니다.");

            }
        }else{
            startToast("이메일 또는 비밀번호가 입력되지 않았습니다.");
        }

        }
        private void startToast(String msg){
            Toast.makeText(this, msg,
                    Toast.LENGTH_SHORT).show();

    }
    private void MystartActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //뒤로가기 버튼을 눌렀을 경우 로그인창이나 회원가입 창이 안뜨고 바로 꺼지도록함.
        startActivity(intent);
    }
}
