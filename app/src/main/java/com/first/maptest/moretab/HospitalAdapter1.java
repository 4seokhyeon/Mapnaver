package com.first.maptest.moretab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.HospitalData;
import com.first.maptest.R;

import java.util.List;

public class HospitalAdapter1 /*extends RecyclerView.Adapter<HospitalAdapter1.HospitalDataViewHolder>*/{
    private final List<HospitalData> hospitalDataList;

    public HospitalAdapter1(List<HospitalData> hospitalDataList) {
        this.hospitalDataList = hospitalDataList;
    }


   /* @NonNull
    @Override
    public HospitalAdapter1.HospitalDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter1.HospitalDataViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }*/
}
