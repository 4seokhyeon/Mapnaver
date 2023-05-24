package com.first.maptest.moretab;

import static com.first.maptest.fragment.Fragment1.naverMap;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.HospitalAdapter;
import com.first.maptest.HospitalData;
import com.first.maptest.R;
import com.naver.maps.geometry.LatLng;

import java.lang.ref.Reference;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


public class HospitalActivity extends AppCompatActivity {
    private final String ServiceKey = "SPDSn/BJUGuyatbQ8AZUwNo1QheqcTgc2Ljmn7uE+uoVo3CfD1ceb57Lb/QE8Y3lhzGwq2/+ecds93iK0kNTsg==";
    private static final String TAG = HospitalActivity.class.getSimpleName();
    private RecyclerView hospitalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);


        hospitalListView = findViewById(R.id.activity_hospital);
        hospitalListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        double longitude = getIntent().getDoubleExtra("longitude", 0);
        double latitude = getIntent().getDoubleExtra("latitude", 0);
        Log.d("Activity", "경도=" + longitude + ", 위도=" + latitude);

        LatLng mapCenter = naverMap.getCameraPosition().target;
        getHospBasisList(ServiceKey, Double.toString(mapCenter.longitude), Double.toString(mapCenter.latitude), "500");
    }

    private void getHospBasisList(String s, String XPos, String YPos, String m) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apis.data.go.kr/B551182/hospInfoServicev2/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                        .build())
                .build();


        HospitalApi hospitalApi = retrofit.create(HospitalApi.class);
        hospitalApi.getHsptlBassInfo(s, XPos, YPos, m).enqueue(new Callback<HospitalData>() {
            @Override
            public void onResponse(Call<HospitalData> call, Response<HospitalData> response) {
                if (response.code() == 200) {
                    HospitalData result = response.body();
                    updateList(result);
                }
            }

            @Override
            public void onFailure(Call<HospitalData> call, Throwable t) {
                Log.e("chek", "Request failed: " + t.getMessage());
            }
        });
    }

    private void updateList(HospitalData result) {
       /* if (result.hospitalData != null && result.hospitalData.size() > 0) {
            Collections.sort(result.hospitalDatas);
            //Collections.sort(result.stores, new Store.NameSorter());
            //Collections.sort(result.stores, new Store.StockAtSorter());
            HospitalAdapter adapter = new HospitalAdapter(result.hospitalDatas);
            hospitalListView.setAdapter(adapter);

        }*/


    }
}

