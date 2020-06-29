package com.joy50.kendrobinduadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout addNewStudent;
    private LinearLayout publishResult;
    private LinearLayout setOnlineClass;
    private LinearLayout reviewAssignments;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addNewStudent = findViewById(R.id.add_student);
        addNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddStudentActivity.class));
            }
        });

        publishResult = findViewById(R.id.set_results);
        publishResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SetResultActivity.class));
            }
        });

        setOnlineClass = findViewById(R.id.set_online_class);
        setOnlineClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SetOnlineClassActivity.class));
            }
        });

        reviewAssignments = findViewById(R.id.review_assignments_home);
        reviewAssignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ReviewAssignmentsActivity.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
            {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}