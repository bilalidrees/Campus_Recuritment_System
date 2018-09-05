package com.example.bilalidrees.crs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Company extends AppCompatActivity {

    private ListView mCompanyListView;
    private Company_Adapter comadapter;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mComDatabaseReference;
    private ChildEventListener mChildEventListener;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        mCompanyListView = findViewById(R.id.CompanyListView);
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mComDatabaseReference = mFirebaseDatabase.getReference().child("Company");
        Log.v("bilal", mComDatabaseReference.toString());

        if (mAuth.getCurrentUser() != null) {

            final List<job_data> com = new ArrayList<>();

            comadapter=new Company_Adapter(this,R.layout.student_listview,com);

            mCompanyListView.setAdapter(comadapter);


            

            attachDatabaseReadListener();
        }


    }

    private void attachDatabaseReadListener() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                        job_data jd = postSnapshot.getValue(job_data.class);
                        comadapter.add(jd);
                        comadapter.notifyDataSetChanged();



                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            };
            mComDatabaseReference.addChildEventListener(mChildEventListener);

        }
    }
}
