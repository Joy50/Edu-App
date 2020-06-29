package com.joy50.kendrobinduadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    private ImageView addNewStudent;
    private RecyclerView studentInfoRecyclerView;
    public FirebaseDatabase databaseOfStudents;
    public static DatabaseReference studentDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        addNewStudent = findViewById(R.id.add_new_student);
        addNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),NewStudentInfoAddActivity.class));
            }
        });

        databaseOfStudents = FirebaseDatabase.getInstance();
        studentDatabaseRef = databaseOfStudents.getReference("Studentinfo");

        studentInfoRecyclerView = findViewById(R.id.student_info_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        studentInfoRecyclerView.setLayoutManager(layoutManager);
        studentInfoRecyclerView.setHasFixedSize(true);

        List<StudentsInfoModel> studentsInfoModelList = new ArrayList<>();
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));
        studentsInfoModelList.add(new StudentsInfoModel("Joy","Class 5"));

        StudentInfoAdapter studentInfoAdapter = new StudentInfoAdapter(studentsInfoModelList);
        studentInfoRecyclerView.setAdapter(studentInfoAdapter);
        studentInfoAdapter.notifyDataSetChanged();

    }
}