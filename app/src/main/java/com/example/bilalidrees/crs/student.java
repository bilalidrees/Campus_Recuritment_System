package com.example.bilalidrees.crs;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class student extends Fragment {

    private ListView mStudentListView;
    private Student_Adapter stuadapter;


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mStudentDatabaseReference;
    private ChildEventListener mChildEventListener;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student, container, false);
        // btnTEST = (Button) view.findViewById(R.id.btnTEST);
        mStudentListView = view.findViewById(R.id.StudentListView);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mStudentDatabaseReference = mFirebaseDatabase.getReference().child("Students");

        if (mAuth.getCurrentUser() != null) {

            final List<Student_Data> studata = new ArrayList<>();

            stuadapter=new Student_Adapter(getActivity(),R.layout.student_listview,studata);

            mStudentListView.setAdapter(stuadapter);



            attachDatabaseReadListener();


            mStudentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                   Student_Data sd=studata.get(position);

                    showupdatedialog(sd);
                }
            });
        }


        return view;
    }





    private void attachDatabaseReadListener() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {

                        Student_Data sd = postSnapshot.getValue(Student_Data.class);

                        Log.v("datasnapshot key",dataSnapshot.getKey());

                        Log.v("postsnapshot key",postSnapshot.getKey());

                        stuadapter.add(sd);

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
            mStudentDatabaseReference.addChildEventListener(mChildEventListener);

        }
    }


private  void  showupdatedialog(Student_Data sd){
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getLayoutInflater();
    final View dialogView = inflater.inflate(R.layout.update_student, null);
    dialogBuilder.setView(dialogView);

   final EditText Edit_name,Edit_f_name,Edit_qualification,Edit_email,Edit_skills;

   final Button update_btn;


    Edit_name=dialogView.findViewById(R.id.editTextStu_name);
    Edit_f_name=dialogView.findViewById(R.id.editTextStu_name);
    Edit_qualification=dialogView.findViewById(R.id.editTextStu_qualification);
    Edit_email=dialogView.findViewById(R.id.editTextStu_email);
    Edit_skills=dialogView.findViewById(R.id.editTextStu_skills);

    update_btn=dialogView.findViewById(R.id.update);


    update_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String name=Edit_name.getText().toString().trim();
            String fname=Edit_f_name.getText().toString().trim();
            String qualification=Edit_qualification.getText().toString().trim();
            String email=Edit_email.getText().toString().trim();
            String skills=Edit_skills.getText().toString().trim();


        }
    });

    dialogBuilder.setTitle("Student Update");
    final AlertDialog b = dialogBuilder.create();
    b.show();
}

}
