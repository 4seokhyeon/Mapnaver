package com.first.maptest.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.moretab.customer;
import com.first.maptest.moretab.my;
import com.first.maptest.moretab.notice;
import com.first.maptest.moretab.pop;
import com.first.maptest.moretab.review;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

//즐겨찾기 및 리뷰, 캘린더
public class Fragment4 extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    TextView nameTxt, birthTxt, pbTxt;

    public static Fragment4 newInstance() {
        return new Fragment4();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_4, container, false);

        nameTxt = (TextView) rootView.findViewById(R.id.nameTxt);
        birthTxt = (TextView) rootView.findViewById(R.id.birthTxt);
        pbTxt = (TextView) rootView.findViewById(R.id.pbTxt);

        db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                String name = document.getString("name");
                                String birth = document.getString("birthday");
                                String pb = document.getString("p_num");


                                nameTxt.setText(name);
                                birthTxt.setText(birth);
                                pbTxt.setText(pb);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });

        /*Button my = rootView.findViewById(R.id.my);
        my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.my my = new my();
                fragmentTransaction.replace(R.id.mainframe, my);
                fragmentTransaction.commit();
            }

        });*/


        Button review = rootView.findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.review review = new review();
                fragmentTransaction.replace(R.id.mainframe, review);
                fragmentTransaction.commit();
            }
        });

        Button pop = rootView.findViewById(R.id.pop);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.pop pop = new pop();
                fragmentTransaction.replace(R.id.mainframe, pop);
                fragmentTransaction.commit();
            }
        });

        Button customer = rootView.findViewById(R.id.customer);
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.customer customer = new customer();
                fragmentTransaction.replace(R.id.mainframe, customer);
                fragmentTransaction.commit();
            }
        });

        Button notice = rootView.findViewById(R.id.notice);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                com.first.maptest.moretab.notice notice = new notice();
                fragmentTransaction.replace(R.id.mainframe, notice);
                fragmentTransaction.commit();
            }
        });


        /*Button LogOutButton = rootView.findViewById(R.id.LogOutButton);
        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });*/
        


        return rootView;
    }
}