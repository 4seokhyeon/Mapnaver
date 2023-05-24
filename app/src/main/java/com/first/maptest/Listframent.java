package com.first.maptest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.first.maptest.moretab.reserve2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//병원 리스트 클래스
public class Listframent extends AppCompatActivity implements ondata{
    private RecyclerView recyclerView;
    private ArrayList<Hospital>arrayList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private FragmentManager fragmentManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hopitalview);
        recyclerView=findViewById(R.id.hospital);
        initdata();

    }
    public void back(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    private void initdata(){
        arrayList=new ArrayList<>();
        arrayList=getIntent().getParcelableArrayListExtra("hospital");
        fragmentManager=getSupportFragmentManager();

        adapter=new HospitalAdapter(arrayList,this);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void sendlist(ArrayList<Hospital> arrayList) {
        this.arrayList=arrayList;
    }
}
