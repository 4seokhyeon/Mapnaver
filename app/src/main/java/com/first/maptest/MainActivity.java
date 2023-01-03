package com.first.maptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
        //하단바 네비게이션 뷰 코드 and 스위치 문으로 각 프래그먼트를 연결
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
//드디어 해냈다 야발