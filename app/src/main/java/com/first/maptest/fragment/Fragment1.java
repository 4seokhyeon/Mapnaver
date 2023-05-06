package com.first.maptest.fragment;

import android.Manifest;
import android.content.Context;
import android.graphics.PointF;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.HospitalData;
import com.first.maptest.Listframent;
import com.first.maptest.R;
import com.first.maptest.moretab.HospitalApi;
import com.first.maptest.moretab.ItemClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
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

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//네이버 지도 프래그먼트 코드
public class Fragment1 extends Fragment implements Overlay.OnClickListener,
        OnMapReadyCallback,NaverMap.OnCameraChangeListener, NaverMap.OnCameraIdleListener, NaverMap.OnMapClickListener {
    private static final int ACCESS_LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private boolean isCameraAnimated = false;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseFirestore db;
    public List<HospitalData> hospitals;
    private final String ServiceKey="SPDSn%2FBJUGuyatbQ8AZUwNo1QheqcTgc2Ljmn7uE%2BuoVo3CfD1ceb57Lb%2FQE8Y3lhzGwq2%2F%2Becds93iK0kNTsg%3D%3D";
    //지도 객체 변수
    private Geocoder geocoder;
    private MapView mapView;
    private static NaverMap naverMap;
    private FusedLocationSource locationSource;
    private InfoWindow infoWindow;
    private List<Marker> markerList = new ArrayList<Marker>();
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

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


        Fragment1.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);
        requestPermissions(PERMISSIONS, LOCATION_PERMISSION_REQUEST_CODE);

        naverMap.addOnCameraChangeListener(this);
        naverMap.addOnCameraIdleListener(this);
        naverMap.setOnMapClickListener(this);

        LatLng mapCenter = naverMap.getCameraPosition().target;
        fetchStoreSale(ServiceKey,Double.toString(mapCenter.longitude), Double.toString(mapCenter.latitude), "5000");

        //ui 셋팅
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);
        uiSettings.setZoomControlEnabled(false);
        naverMap.getUiSettings().setZoomControlEnabled(true);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case ACCESS_LOCATION_PERMISSION_REQUEST_CODE:
                locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults);
                return;
        }
    }

    private void fetchStoreSale(String s,String WGS84_LON, String WGS84_LAT, String m) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/B551182/hospInfoServicev2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();


        HospitalApi hospitalApi = retrofit.create(HospitalApi.class);
        hospitalApi.getHsptlBassInfo(s,WGS84_LON, WGS84_LAT, m).enqueue(new Callback<HospitalData>() {
            @Override
            public void onResponse(Call<HospitalData> call, Response<HospitalData> response) {
                if (response.code() == 200) {
                    HospitalData result = response.body();
                    Log.d("chek", String.valueOf(result));

                    updateMapMarkers(result);
               }
            }
            @Override
            public void onFailure(Call<HospitalData> call, Throwable t) {
                Log.e("FetchStoreSale", "Request failed: " + t.getMessage());
            }
        });
    }

    private void updateMapMarkers(HospitalData result) {
        resetMarkerList();
        if (result.getBodyClass().getItems() != null && result.getBodyClass().getItems().size() > 0) {
            for (ItemClass item : result.getBodyClass().getItems()) {
                Marker marker = new Marker();
                marker.setTag(item);
                marker.setPosition(new LatLng(Double.parseDouble(item.getWGS84_LON()),Double.parseDouble(item.getWGS84_LAT()) ));
                Log.d("chek", item.getWGS84_LON());
                marker.setAnchor(new PointF(0.5f, 1.0f));
                marker.setMap(naverMap);
                marker.setOnClickListener(this);
                markerList.add(marker);
            }
        }
    }

    private void resetMarkerList() {
        if (markerList != null) {
            for (Marker marker : markerList) {
                marker.setMap(null);
            }
            markerList.clear();
        }
    }

    @Override
    public void onCameraChange(int i, boolean b) {
        boolean animated = false;
        isCameraAnimated = animated;

    }

    @Override
    public void onCameraIdle() {
        if (isCameraAnimated) {
            LatLng mapCenter = naverMap.getCameraPosition().target;
            fetchStoreSale(ServiceKey,Double.toString(mapCenter.latitude), Double.toString(mapCenter.longitude), "5000");
        }

    }

    @Override
    public void onMapClick(@NonNull PointF pointF, @NonNull LatLng latLng) {
        if (infoWindow.getMarker() != null) {
            infoWindow.close();
        }

    }

    @Override
    public boolean onClick(@NonNull Overlay overlay) {
        if (overlay instanceof Marker) {
            Marker marker = (Marker) overlay;
            if (marker.getInfoWindow() != null) {
                infoWindow.close();
            } else {
                infoWindow.open(marker);
            }
            return true;
        }
        return false;

    }
}



