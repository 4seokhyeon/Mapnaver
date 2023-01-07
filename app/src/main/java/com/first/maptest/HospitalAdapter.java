package com.first.maptest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

    private ArrayList<Hospital> arrayList;
    private Context context;


    public HospitalAdapter(ArrayList<Hospital> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HospitalAdapter.HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hospital,parent,false);
        HospitalViewHolder holder=new HospitalViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter.HospitalViewHolder holder, int position) {
        /*Glide.with(holder.itemView)
                .load(arrayList.get(position).getProfile())
                .into(holder.iv_profile);*/
        holder.tv_addr.setText(arrayList.get(position).getAddr());
        holder.tv_h_name.setText(arrayList.get(position).getH_name());
        holder.tv_h_type.setText(arrayList.get(position).getH_type());

    }

    @Override
    public int getItemCount() {
        //삼항 연산자
        return (arrayList !=null ? arrayList.size() :0);
    }

    public class HospitalViewHolder extends RecyclerView.ViewHolder {
        LinearLayout listH;
        //ImageView iv_profile; 나중에 병원 이미지 넣고 할 예정
        TextView tv_addr;
        TextView tv_h_name;
        TextView tv_h_type;


        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);
           // this.iv_profile=itemView.findViewById(R.id.iv_profile);
            this.listH=itemView.findViewById(R.id.listH);
            this.tv_addr=itemView.findViewById(R.id.tv_addr);
            this.tv_h_name=itemView.findViewById(R.id.tv_h_name);
            this.tv_h_type=itemView.findViewById(R.id.tv_h_type);
        }
    }
}
