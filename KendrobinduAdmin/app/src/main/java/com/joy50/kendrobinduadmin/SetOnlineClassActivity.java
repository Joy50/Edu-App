package com.joy50.kendrobinduadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SetOnlineClassActivity extends AppCompatActivity {

    private ImageView addOnlineClass;
    private RecyclerView onlineClassExamRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_online_class);

        getSupportActionBar().setTitle("Online Class Schedule");

        addOnlineClass = findViewById(R.id.add_online_classes_exams_schedule);
        addOnlineClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddOnlineClassesAndExams.class));
            }
        });

        onlineClassExamRecyclerView = findViewById(R.id.online_classes_exams_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        onlineClassExamRecyclerView.setLayoutManager(layoutManager);
        onlineClassExamRecyclerView.setHasFixedSize(true);

        List<SetOnlineClassExamModel> onlineClassExamModelList = new ArrayList<>();
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));
        onlineClassExamModelList.add(new SetOnlineClassExamModel("Class 5","www.facebook.com","www.google.com","11:00 AM"));

        SetOnlineClassExamAdapter setOnlineClassExamAdapter = new SetOnlineClassExamAdapter(onlineClassExamModelList);
        onlineClassExamRecyclerView.setAdapter(setOnlineClassExamAdapter);
        setOnlineClassExamAdapter.notifyDataSetChanged();
    }
}