package com.example.bilalidrees.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.FirebaseAuth;

public class profile_student extends AppCompatActivity implements View.OnClickListener{
    FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mStudentDatabaseReference;



    EditText Edit_name,Edit_f_name,Edit_qualification,Edit_email,Edit_skills;




    public profile_student() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mAuth=FirebaseAuth.getInstance();

       mFirebaseDatabase=FirebaseDatabase.getInstance();

        mStudentDatabaseReference=mFirebaseDatabase.getReference().child("Students");

        Edit_name=findViewById(R.id.editTextStu_name);
        Edit_f_name=findViewById(R.id.editTextStu_name);
        Edit_qualification=findViewById(R.id.editTextStu_qualification);
        Edit_email=findViewById(R.id.editTextStu_email);
        Edit_skills=findViewById(R.id.editTextStu_skills);

        findViewById(R.id.submit).setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_frag_loader, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.Signout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this,welcome.class));

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.submit:
                FirebaseUser user=mAuth.getCurrentUser();

                Student_Data student=new Student_Data(Edit_name.getText().toString(),Edit_f_name.getText().toString()
                        ,Edit_qualification.getText().toString(),Edit_email.getText().toString(),
                        Edit_skills.getText().toString());






                Log.v("bilal", mStudentDatabaseReference.toString());


                mStudentDatabaseReference.child(user.getUid()).push().setValue(student);

                //Toast.makeText(profile_student.this,"failed",Toast.LENGTH_SHORT);

                // Clear input box
                Edit_name.setText("");Edit_f_name.setText("");Edit_qualification.setText("");Edit_email.setText("");Edit_skills.setText("");


        }

    }
}
