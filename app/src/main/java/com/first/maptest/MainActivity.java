package com.first.maptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.first.maptest.fragment.Fragment1;
import com.first.maptest.fragment.Fragment2;
import com.first.maptest.fragment.Fragment3;
import com.first.maptest.fragment.Fragment4;
import com.first.maptest.fragment.Fragment5;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //병원 목록 파이어베이스 부분
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Hospital> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference; //파이어 베이스 전역 변수 선언 부분

    private long backBtnTime = 0;

    private BottomNavigationView bottomNavigationView; //바텀 네비게이션뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;
    private Listframent listframent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //세로모드고정
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        setFragment(0);
    }

    @Override
    public void onBackPressed() {
        long curTime=System.currentTimeMillis();
        long gapTime=curTime-backBtnTime;

        if(0<=gapTime && 2000>=gapTime){
            super.onBackPressed();
        }
        else{
            backBtnTime=curTime;
            Toast.makeText(this,"한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }
    }

    public void setFragment(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 0:
                ft.replace(R.id.mainframe, fragment1);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.mainframe, fragment2);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.mainframe, fragment3);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.mainframe, fragment4);
                ft.commit();
                break;
            case 4:
                ft.replace(R.id.mainframe, fragment5);
                ft.commit();
                break;
        }
    }
}
//최현지 디지셈
//드디어 해냈다 야발
//어렵누
//조용히해 이 사람아