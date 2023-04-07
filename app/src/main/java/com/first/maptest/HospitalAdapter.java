package com.first.maptest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.moretab.reserve2;

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


            Button rs = itemView.findViewById(R.id.rs);
            rs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tv_h_name = itemView.findViewById(R.id.tv_h_name);

                    String hname = tv_h_name.getText().toString();

                    FragmentTransaction fragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
                    reserve2 reserve2 = new reserve2();
                    Bundle bundle = new Bundle();
                    bundle.putString("hname",hname);
                    reserve2.setArguments(bundle);
                    fragmentTransaction.replace(R.id.mainframe, reserve2);
                    fragmentTransaction.commit();


                }
            });
        }

    }

}
