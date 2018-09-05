package com.example.bilalidrees.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class welcome extends AppCompatActivity {
public Button student,admin,company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        student=(Button)findViewById(R.id.StudentLogin);
        admin=(Button)findViewById(R.id.AdminLogin);
        company=(Button)findViewById(R.id.CompanyLogin);
        FirebaseAuth instance = FirebaseAuth.getInstance();
//        instance!=null
//        instance.getCurrentUser().getUid()


        student.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Student_login.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Admin_login.class);
                startActivity(intent);
            }
        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Company_login.class);
                startActivity(intent);
            }
        });

    }
}
