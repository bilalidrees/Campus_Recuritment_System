package com.example.bilalidrees.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class s_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_list);

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
