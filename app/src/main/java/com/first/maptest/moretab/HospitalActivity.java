package com.first.maptest.moretab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.HospitalData;
import com.first.maptest.R;
import com.naver.maps.geometry.LatLng;

import java.lang.ref.Reference;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class HospitalActivity extends AppCompatActivity {
    private static final String TAG = HospitalActivity.class.getSimpleName();
    private RecyclerView hospitalListView;

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        setTitle("판매처 목록");

        hospitalListView = findViewById(R.id.activity_hospital);
        hospitalListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        double longitude = getIntent().getDoubleExtra("longitude", 0);
        double latitude = getIntent().getDoubleExtra("latitude", 0);
        Log.i("Activity", "경도=" + longitude + ", 위도=" + latitude);

        //fetchStoreSale(latitude, longitude, 5000);
    }

    /*private void fetchStoreSale(double lat, double lng, int m) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HospitalApi hospitalApi = retrofit.create(HospitalApi.class);
        Call<HospitalApi.HospitalResult> call = HospitalApi.getHospitals(xPos, yPos, m);
        call.enqueue(new Callback<HospitalApi.HospitalResult>() {
            @Override
            public void onResponse(Call<HospitalApi.HospitalResult> call, Response<HospitalApi.HospitalResult> response) {
                if (response.code() == 200) {
                    HospitalApi.HospitalResult result = response.body();
                    updateList(result);
                }
            }

            @Override
            public void onFailure(Call<HospitalApi.HospitalResult> call, Throwable t) {
                // Handle failure
            }
        });
    }

    private void updateList(HospitalResult result) {
        if (result != null && result.getHospitals() != null) {
            Collections.sort(result.getHospitals());
            HospitalAdapter1 adapter = new HospitalAdapter1(result.getHospitals());
            hospitalListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            // Clear existing markers on the map
            Reference<Object> mMap = null;
            mMap.clear();

            // Add markers for each hospital to the map
            for (HospitalData hospital : result.getHospitalData()) {
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(new LatLng(hospital.getLatitude(), hospital.getLongitude()))
                        .title(hospital.getName())
                        .snippet(hospital.getAddress());
                mMap.addMarker(markerOptions);
            }
        }
}*/
}

