package com.first.maptest.moretab.accompaying;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.first.maptest.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

//병원동행 예약내역
public class rv2 extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String date, time, ps;
    TextView nameTxt, ageTxt, bgTxt;

    public static rv2 newInstance()
    {
        return new rv2();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.rv2, container, false);

        nameTxt = (TextView) rootView.findViewById(R.id.nameTxt);
        ageTxt = (TextView) rootView.findViewById(R.id.ageTxt);
        bgTxt = (TextView) rootView.findViewById(R.id.bgTxt);

        if(getArguments()!=null){
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            ps = getArguments().getString("ps");
        }

        db.collection("MN")
                .whereEqualTo("name",ps)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Log.d(TAG, document.getId() + "=>" + document.getString("name"));
                                String name = document.getString("name");
                                String age = document.getString("age");
                                String bg = document.getString("bg");

                                Log.d(TAG, "***>"+age);

                                nameTxt.setText("이름: "+name);
                                ageTxt.setText("나이: "+age);
                                bgTxt.setText("자격증: "+bg);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });

        //매니저
        Button pp = rootView.findViewById(R.id.pp);
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                hp2 hp2 = new hp2();

                fragmentTransaction.replace(R.id.mainframe, hp2);
                fragmentTransaction.commit();

                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("ps", ps);
                hp2.setArguments(bundle);

                String matchedPerson = ps+"님과 매칭이 완료되었습니다.";
                Toast.makeText(getActivity().getApplicationContext(), matchedPerson, Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}
