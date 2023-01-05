package com.first.maptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Listframent extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Hospital>arrayList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FragmentManager fragmentManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.hopitalview,
                container, false);
        recyclerView=rootView.findViewById(R.id.hospital);
        initdata();

        return rootView;
    }
    private void initdata(){
        arrayList=new ArrayList<>();
        fragmentManager=getActivity().getSupportFragmentManager();
        //여기 주석 풀지마 이 새 끼 뜰아 연결해놓은거라 냅둬라;
        /*database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Host");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                arrayList.clear();
                for(DataSnapshot snapshot : snapshot1.getChildren()){  //데이터 전부를 가져오는 부분 hospital 주소확인후 넣는 방식으로 지오로 위도 경도 확인후 비교하여 범위 내에 있을경우 arraylist에 추가 하게끔 아니면 다른 arraylist를 만들어서
                주소를 비교한 리스트만 넣고
                hospital 어댑터의 arraylist를 새로만든 리스트로 변경
                    Hospital hospital=snapshot.getValue(Hospital.class);
                    arrayList.add(hospital);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        arrayList.add(new Hospital("서울","한방병원","주소"));
        adapter=new HospitalAdapter(arrayList,getContext());
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }
}
