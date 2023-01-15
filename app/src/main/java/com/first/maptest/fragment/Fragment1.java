package com.first.maptest.fragment;

import android.Manifest;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.Listframent;
import com.first.maptest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

//네이버 지도 프래그먼트 코드
public class Fragment1 extends Fragment implements Overlay.OnClickListener,OnMapReadyCallback {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    //final Geocoder geocoder = new Geocoder(this.getContext());
    //지도 객체 변수
    private MapView mapView;
    private static NaverMap naverMap;
    private FusedLocationSource locationSource;
    private InfoWindow infoWindow;
    private static final int LOCATION_PERMISSION_REQUEST_CODE=1000;
    private static final String[] PERMISSIONS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    public Fragment1() { }

    public static Fragment1 newInstance()
    {
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_1,
                container, false);
        Button listButton=rootView.findViewById(R.id.listButton);

        mapView = (MapView) rootView.findViewById(R.id.navermap);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        locationSource= new FusedLocationSource(this,LOCATION_PERMISSION_REQUEST_CODE);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Host");

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                Listframent listframent=new Listframent();
                fragmentTransaction.replace(R.id.mainframe,listframent);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

        Fragment1.naverMap =naverMap;
        naverMap.setLocationSource(locationSource);
        requestPermissions(PERMISSIONS,LOCATION_PERMISSION_REQUEST_CODE);
        //ui 셋팅
        UiSettings uiSettings=naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
        uiSettings.setZoomControlEnabled(false);




    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {
        Marker marker=(Marker) overlay;
        infoWindow.open(marker);

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permissions,@NonNull int[] grantResults) {
        if(locationSource.onRequestPermissionsResult(requestCode,permissions,grantResults)){
            if(!locationSource.isActivated()){
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            }
            else {
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    public void onStart() {
        String addr;
        super.onStart();
        mapView.onStart();
    }
    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    @Override
    public void onStop(){
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory(){
        super.onLowMemory();
        mapView.onLowMemory();
    }
}