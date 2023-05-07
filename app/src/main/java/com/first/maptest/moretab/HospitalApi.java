package com.first.maptest.moretab;

import com.first.maptest.HospitalData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface HospitalApi {
    //@Headers("Accept: application/json")
    @GET("getHospBasisList")
    Call<HospitalData> getHsptlBassInfo(@Query("ServiceKey") String s,
                                        @Query("xPos") String lon,
                                        @Query("yPos") String lat,
                                        @Query("radius") String radius);

}


