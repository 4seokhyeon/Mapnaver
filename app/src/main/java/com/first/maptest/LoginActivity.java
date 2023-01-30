package com.first.maptest;

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

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.LoginButton).setOnClickListener(onClickListener);
        findViewById(R.id.gotoPasswordResetButton).setOnClickListener(onClickListener);
        findViewById(R.id.gotoSignUpButton).setOnClickListener(onClickListener);
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    //뒤로가기 버튼을 눌렀을 때 꺼지게 함
   public void onBackPressed(){
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.LoginButton:
                    login();
                    break;
                case R.id.gotoPasswordResetButton:
                    MystartActivity(PasswordResetActivity.class);
                    break;
                case R.id.gotoSignUpButton:
                    MystartActivity(SignUpActivity.class);
                    break;
            }
        }
    };

    private void login(){

        String email = ((EditText)findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText)findViewById(R.id.passwordEditText)).getText().toString();

        if(email.length()>0&&password.length()>0){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                startToast("로그인에 성공했습니다.");
                                MystartActivity(MainActivity.class);
                                //로그인에 성공한 경우 실행되는 화면을 지정(아래의 함수 사용)
                            } else {
                                if(task.getException()!=null) {
                                    startToast(task.getException().toString());
                                }
                            }
                        }
                    });
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
        startActivity(intent);
    }
}
