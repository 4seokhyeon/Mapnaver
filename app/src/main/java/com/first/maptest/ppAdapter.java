package com.first.maptest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ppAdapter extends RecyclerView.Adapter<ppAdapter.ViewHolder> {

    private ArrayList<String> ppdataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
        public TextView getTextView(){
            return textView;
        }
    }

    public ppAdapter(ArrayList<String>dataSet){
        ppdataSet = dataSet;
    }

    @NonNull
    @Override
    public ppAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pp_item,parent,false);
        ppAdapter.ViewHolder viewHolder = new ppAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ppAdapter.ViewHolder holder, int position) {
        String text = ppdataSet.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return ppdataSet.size();
    }
}//
