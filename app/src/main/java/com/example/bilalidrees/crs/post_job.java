package com.example.bilalidrees.crs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class post_job extends Fragment  implements View.OnClickListener {
    FirebaseAuth mAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mCompanyDatabaseReference;

    EditText c_name,j_title,r_q,r_s,exp,c_salary,loc;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_job, container, false);
        // btnTEST = (Button) view.findViewById(R.id.btnTEST);
        mAuth=FirebaseAuth.getInstance();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mCompanyDatabaseReference=mFirebaseDatabase.getReference().child("Company");

        c_name=view.findViewById(R.id.Company_name);
        j_title=view.findViewById(R.id.job_title);
        r_q=view.findViewById(R.id.required_qualification);
        r_s=view.findViewById(R.id.required_skills);
        exp=view.findViewById(R.id.com_expeireince);
        c_salary=view.findViewById(R.id.com_salary);
        loc=view.findViewById(R.id.com_Location);

        view.findViewById(R.id.post).setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.post:
                FirebaseUser user=mAuth.getCurrentUser();

               job_data jb=new job_data(c_name.getText().toString(),j_title.getText().toString(),
                       r_q.getText().toString(),r_s.getText().toString(),exp.getText().toString(),
                       c_salary.getText().toString(),loc.getText().toString());

                mCompanyDatabaseReference.child(user.getUid()).push().setValue(jb);
                Log.v("bilal", mCompanyDatabaseReference.toString());

                c_name.setText("");j_title.setText("");r_q.setText("");r_s.setText("");
                exp.setText("");c_salary.setText("");loc.setText("");





        }

    }
}
