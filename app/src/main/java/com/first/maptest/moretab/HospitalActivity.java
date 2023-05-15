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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        hospitalListView = findViewById(R.id.activity_hospital);
        hospitalListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        double lat = getIntent().getDoubleExtra("longitude", 0);
        double latitude = getIntent().getDoubleExtra("latitude", 0);
        Log.d("Activity", "경도=" + lat + ", 위도=" + latitude);

        //getHospBasisList(ServiceKey,Double.toString(mapCenter.longitude), Double.toString(mapCenter.latitude), "500");
    }

    /*private void getHospBasisList(String s,String XPos, String YPos, String m) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/B551182/hospInfoServicev2/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();


        HospitalApi hospitalApi = retrofit.create(HospitalApi.class);
        hospitalApi.getHsptlBassInfo(s,XPos, YPos, m).enqueue(new Callback<HospitalData>() {
            @Override
            public void onResponse(Call<HospitalData> call, Response<HospitalData> response) {
                if (response.code() == 200) {
                    HospitalData result = response.body();
                    updateMapMarkers(result);
                }
            }
            @Override
            public void onFailure(Call<HospitalData> call, Throwable t) {
                Log.e("chek", "Request failed: " + t.getMessage());
            }
        });
    }

   private void updateMapMarkers(HospitalData result) {
        if (!isAdded()) {
            // Fragment is not attached to the activity, return or handle the situation accordingly
            return;
        }
        resetMarkerList();
        if (result.getBodyClass().getItems() != null && result.getBodyClass().getItems().size() > 0) {
         Collections.sort(result.hospitalDatas);
         HospitalAdapter1 adapter = new HospitalAdapter1(result.hospitalDatas);
            hospitalDataListView.setAdapter(adapter);
        }
}*/
}

