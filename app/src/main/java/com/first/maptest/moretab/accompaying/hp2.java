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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class hp2 extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DocumentReference docuser = db.collection("Users").document(Uid);

    String date, time, ps;
    TextView tv_date, tv_time, tv_ps, tv_name;
    private DataSnapshot mDatabase;

    public static hp2 newInstance()
    {
        return new hp2();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.hp2, container, false);


        tv_date = (TextView) rootView.findViewById(R.id.tv_date);
        tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        tv_ps = (TextView) rootView.findViewById(R.id.tv_ps);
        tv_name = (TextView) rootView.findViewById(R.id.tv_name);

        if(getArguments()!=null){
            date = getArguments().getString("date");
            time = getArguments().getString("time");
            ps = getArguments().getString("ps");

            tv_date.setText(date);
            tv_time.setText(time);
            tv_ps.setText(ps);
        }

        /*db.collection("Users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Log.d(TAG, document.getId() + "=>" + document.getString("name"));
                                String name = document.getString("name");
                                tv_name.setText(name);
                            }
                        }else{
                            Log.d(TAG,"Error getting documents: ", task.getException());
                        }
                    }
                });*/

        docuser.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String name = documentSnapshot.getString("name");

                tv_name.setText(name);
            }
        });

        Button back1 = rootView.findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                rv2 rv2 = new rv2();
                fragmentTransaction.replace(R.id.mainframe, rv2);
                fragmentTransaction.commit();
            }
        });


        Button end = rootView.findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                hp3 hp3 = new hp3();
                Bundle bundle = new Bundle();
                bundle.putString("date",date);
                bundle.putString("time",time);
                bundle.putString("ps",ps);
                hp3.setArguments(bundle);
                fragmentTransaction.replace(R.id.mainframe, hp3);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }

}

