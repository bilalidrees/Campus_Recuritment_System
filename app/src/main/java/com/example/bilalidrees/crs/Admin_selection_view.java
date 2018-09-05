package com.example.bilalidrees.crs;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Admin_selection_view extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_selection_view);

        findViewById(R.id.s_list).setOnClickListener(this);
        findViewById(R.id.view_companies).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.s_list:

               startActivity(new Intent(this, s_list.class));
               // openFragment();
               /* Intent intent = new Intent(getApplicationContext(), student.class);
                intent.putExtra("position", 2);
                startActivity(intent);
                student fragment = new student();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.StudentListView, fragment);
                transaction.commit();*/
                break;

            case R.id.view_companies:

                startActivity(new Intent(this, Company.class));

                break;

            case R.id.apply_job:
                break;

        }

    }

    private void openFragment()
    {
        //PASS OVER THE BUNDLE TO OUR FRAGMENT
        student stu = new student();
        //THEN NOW SHOW OUR FRAGMENT
        getSupportFragmentManager().beginTransaction().replace(R.id.container,stu).commit();

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