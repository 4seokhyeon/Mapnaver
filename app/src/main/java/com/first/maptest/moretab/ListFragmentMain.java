package com.first.maptest.moretab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.Hospital;
import com.first.maptest.HospitalAdapter;
import com.first.maptest.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListFragmentMain extends Fragment{
    private RecyclerView recyclerView;
    private ArrayList<Hospital>arrayList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FragmentManager fragmentManager;

    public static ListFragmentMain newInstance(){
        return new ListFragmentMain();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_hospital, container, false);
        recyclerView = rootView.findViewById(R.id.activity_hospitals);
        initdata();
        return rootView;
    }
    private void initdata(){
        arrayList=new ArrayList<>();
        arrayList=getArguments().getParcelableArrayList("hospital1");
        fragmentManager=getActivity().getSupportFragmentManager();

        adapter=new HospitalAdapter(arrayList,getContext());
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
