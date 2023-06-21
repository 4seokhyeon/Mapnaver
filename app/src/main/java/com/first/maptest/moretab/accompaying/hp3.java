package com.first.maptest.moretab.accompaying;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.first.maptest.fragment.Fragment1;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class hp3 extends Fragment{

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DocumentReference docuser = db.collection("Users").document(Uid);

    String date, time, Mname;
    TextView tv_date1, tv_time1, tv_ps, tv_name;

    public static hp3 newInstance() {
        return new hp3();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.hp3, container, false);

        tv_date1 = (TextView) rootView.findViewById(R.id.tv_date1);
        tv_time1 = (TextView) rootView.findViewById(R.id.tv_time1);
        tv_ps = (TextView) rootView.findViewById(R.id.tv_ps);
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);

        if(getArguments()!=null) {
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            Mname = getArguments().getString("Mname");

            tv_date1.setText(date);
            tv_time1.setText(time);
            tv_ps.setText("매니저: "+Mname);
        }

        docuser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String name = documentSnapshot.getString("name");

                tv_name.setText(name);
            }
        });

        //완료버튼
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction.replace(R.id.mainframe, fragment1);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }
}
