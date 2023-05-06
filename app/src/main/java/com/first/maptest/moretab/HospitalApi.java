package com.first.maptest.moretab;

import com.first.maptest.HospitalData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface HospitalApi {
    @Headers("Accept: application/json")
    @GET("getHospBasisList1?_type=json")
    Call<HospitalData> getHsptlBassInfo(@Query("ServiceKey") String s,
                                        @Query("WGS84_LON") String lon,
                                        @Query("WGS84_LAT") String lat,
                                        @Query("radius") String radius);

}


