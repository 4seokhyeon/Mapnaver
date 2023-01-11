package com.first.maptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.util.FusedLocationSource;

public class MainActivity extends AppCompatActivity  {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private BottomNavigationView bottomNavigationView; //바텀 네비게이션뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //로그아웃버튼_나중에 다른곳으로 옮길거임(밑에 코드 있음)
        findViewById(R.id.LogOutButton).setOnClickListener(onClickListener);

        if(user==null){
            MystartActivity(LoginActivity.class);
            //메인 화면에서 로그인되어있지 않은 경우 회원가입창으로 넘어감
        }else{
            DocumentReference docRef = db.collection("Users").document(user.getUid());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if(document != null){
                            if (document.exists()) {

                            } else {
                                MystartActivity(MemberInfoActivity.class);
                            }
                        }
                    } else {

                    }
                }
            });
        }

        /* 로그아웃버튼_LogOutButton
        findViewById(R.id.LogOutButton).setOnClickListener(onClickListener);

        View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.LogOutButton:
                    FirebaseAuth.getInstance().signOut();
                    MystartActivity(SignUpActivity.class);
                    break;
            }
        }
    };
         */

        bottomNavigationView=findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_fragment1:
                        setFragment(0);
                        break;
                    case R.id.item_fragment2:
                        setFragment(1);
                        break;
                    case R.id.item_fragment3:
                        setFragment(2);
                        break;
                    case R.id.item_fragment4:
                        setFragment(3);
                        break;
                    case R.id.item_fragment5:
                        setFragment(4);
                        break;
                }
                return true;
            }
        });
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
        fragment5=new Fragment5();
        setFragment(0);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.LogOutButton:
                    FirebaseAuth.getInstance().signOut();
                    MystartActivity(LoginActivity.class);
                    break;
            }
        }
    };
    //뒤로가기 버튼을 눌렀을 때 꺼지게 함
    public void onBackPressed(){
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
        //android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    //화면전환
    private void MystartActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //뒤로가기 버튼을 눌렀을 경우 로그인창이나 회원가입 창이 안뜨고 바로 꺼지도록함.
        startActivity(intent);
    }

   private void setFragment(int n){
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.mainfram,fragment1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.mainfram,fragment2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.mainfram,fragment3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.mainfram,fragment4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.mainfram,fragment5);
                ft.commit();
                break;

        }
    }
}
//최현지 디지셈