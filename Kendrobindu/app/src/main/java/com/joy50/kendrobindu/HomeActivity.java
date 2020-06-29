package com.joy50.kendrobindu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout onlineClass;
    private LinearLayout submitAssignments;
    private LinearLayout checkResult;
    private LinearLayout userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Home");

        onlineClass = findViewById(R.id.online_class);
        onlineClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: Check user if logged in else goto Login activity
                startActivity(new Intent(getApplicationContext(),OnlineClassActivity.class));
            }
        });

        userProfile = findViewById(R.id.user_profile);
        userProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo:if user logged in then UserProfileActivity else Login Activity
                startActivity(new Intent(getApplicationContext(),UserProfileActivity.class));
            }
        });

        submitAssignments = findViewById(R.id.submit_assignment);
        submitAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SubmitAssignmentActivity.class));
            }
        });

        checkResult = findViewById(R.id.results);
        checkResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: Check user if logged in else goto Login activity
                startActivity(new Intent(getApplicationContext(),CheckResultActivity.class));
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
        //MenuInflater inflater = getMenuInflater();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}