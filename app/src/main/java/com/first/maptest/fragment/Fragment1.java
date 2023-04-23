package com.first.maptest.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import com.first.maptest.Hospital;
import com.first.maptest.HospitalApi;
import com.first.maptest.HospitalData;
import com.first.maptest.Listframent;
import com.first.maptest.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.CircleOverlay;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;

//네이버 지도 프래그먼트 코드
public class Fragment1 extends Fragment implements Overlay.OnClickListener, OnMapReadyCallback {
    private HospitalApi thread;
    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 100;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseFirestore db;

    //final Geocoder geocoder = new Geocoder(this.getContext());
    //지도 객체 변수
    private Geocoder geocoder;
    private MapView mapView;
    private static NaverMap naverMap;
    private FusedLocationSource locationSource;
    private InfoWindow infoWindow;
    private List<Marker> markerList = new ArrayList<Marker>();
    private boolean isCameraAnimated = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    ArrayList<Hospital> hospital = new ArrayList<>();

    public Fragment1() {
    }

    public static Fragment1 newInstance() {
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
        Button listButton = rootView.findViewById(R.id.listButton);
        mapView = rootView.findViewById(R.id.navermap);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        locationSource = new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Host");

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Listframent listframent = new Listframent();
                fragmentTransaction.replace(R.id.mainframe, listframent);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        infoWindow = new InfoWindow();

        Fragment1.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        requestPermissions(PERMISSIONS, LOCATION_PERMISSION_REQUEST_CODE);

        //ui 셋팅
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
        uiSettings.setZoomControlEnabled(false);
        naverMap.getUiSettings().setZoomControlEnabled(true);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

        HospitalApi apiData = new HospitalApi();
        ArrayList<HospitalData> dataArr = apiData.getData();
        Log.d("test", dataArr.get(0).getDutyName());
        Log.d("test", dataArr.get(0).getDutyAddr());
        Log.d("test", dataArr.get(0).getDutyTel1());
        Log.d("test", String.valueOf(dataArr.get(0).getWGS84_LAT()));
        Log.d("test", String.valueOf(dataArr.get(0).getWGS84_LON()));
        // 각 병원 정보에 대해 마커 추가
        for (HospitalData data : dataArr) {
            Marker marker = new Marker();
            marker.setPosition(new LatLng(data.getWGS84_LAT(), data.getWGS84_LON()));
            marker.setMap(naverMap);
            marker.setMap(naverMap);
            marker.setOnClickListener(new Overlay.OnClickListener() {
                @Override
                public boolean onClick(@NonNull Overlay overlay) {
                    // Handle marker click event here
                    Toast.makeText(getContext(), "병원이 클릭 되었습니다.", Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

        naverMap.setOnMapClickListener(new NaverMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {

            }

           MapView mapView1 = mapView;

            public boolean onMarkerClick(@NonNull Marker marker, @NonNull MapView mapView) {
                // 마커의 위치를 기반으로 해당 병원 데이터 찾기
                HospitalData hospitalData = null;
                for (HospitalData data : dataArr) {
                    if (data.getWGS84_LAT() == marker.getPosition().latitude &&
                            data.getWGS84_LON() == marker.getPosition().longitude) {
                        hospitalData = data;
                        break;
                    }
                }
                // 해당 병원 데이터가 있을 경우 AlertDialog로 표시
                if (hospitalData != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(hospitalData.getDutyName())
                            .setMessage(hospitalData.getDutyAddr())
                            .setPositiveButton("전화 걸기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // 전화 걸기
                                }
                            })
                            .setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // 닫기
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                return true;
            }
        });
    }
    public boolean onMarkerClick(@NonNull Overlay overlay) {
        if (overlay instanceof Marker) {
            Marker marker = (Marker) overlay;
            // 마커가 클릭되었을 때 처리할 코드 작성
            return true;
        }
        return false;
    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {
       /* Marker marker = (Marker) overlay;
        infoWindow.open(marker);*/

        if(overlay instanceof Marker){
            Marker marker = (Marker) overlay;
            if(marker.getInfoWindow()!=null){
                infoWindow.close();
                Toast.makeText(this.getActivity().getApplicationContext(), "InfoWindow Close", Toast.LENGTH_SHORT).show();
            }else{
                infoWindow.open(marker);
                Toast.makeText(this.getActivity().getApplicationContext(), "InfoWindow Open", Toast.LENGTH_SHORT).show();
            }return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) {
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            } else {
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
