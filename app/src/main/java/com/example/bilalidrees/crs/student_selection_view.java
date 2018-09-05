package com.example.bilalidrees.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class student_selection_view extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_selection_view);

        findViewById(R.id.view_companies).setOnClickListener(this);
        findViewById(R.id.profile).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.profile:

                startActivity(new Intent(this, profile_student.class));
               break;

            case R.id.view_companies:

                startActivity(new Intent(this, Company.class));

                break;

            case R.id.apply_job:
                break;

                }

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

}

