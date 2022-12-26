package com.first.maptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        



        locationSource =
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(35.1798159, 129.0750222), // 대상 지점
                16, // 줌 레벨
                20, // 기울임 각도
                0 // 베어링 각도
        );


        NaverMapOptions options = new NaverMapOptions()
                .camera(cameraPosition)
                .mapType(NaverMap.MapType.Terrain)
                .enabledLayerGroups(NaverMap.LAYER_GROUP_BUILDING)
                .compassEnabled(true)
                .scaleBarEnabled(true)
                .locationButtonEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance(options);
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            return;
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

        naverMap.setOnMapClickListener((point, coord) ->
                Toast.makeText(this, getString(R.string.format_map_click, coord.latitude, coord.longitude),
                        Toast.LENGTH_SHORT).show());

        naverMap.setOnMapLongClickListener((point, coord) ->
                Toast.makeText(this, getString(R.string.format_map_long_click, coord.latitude, coord.longitude),
                        Toast.LENGTH_SHORT).show());

        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);

    }
}
// 최현지 바보같은 자식 이상엽 또라이 같은 자식 박한나 멍청한 자식