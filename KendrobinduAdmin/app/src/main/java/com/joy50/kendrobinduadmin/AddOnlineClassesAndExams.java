package com.joy50.kendrobinduadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddOnlineClassesAndExams extends AppCompatActivity {

    private FirebaseDatabase onlineClassExamDatabase;
    private DatabaseReference onlineClassExamRef;
    private EditText eduLevel;
    private EditText classLink;
    private EditText examLink;
    private EditText timeOfClass;
    private Boolean dataSet = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_online_classes_and_exams);

        eduLevel = findViewById(R.id.education_level);
        classLink = findViewById(R.id.online_class_link);
        examLink = findViewById(R.id.online_exam_link);
        timeOfClass = findViewById(R.id.class_time);

        String levelofEdu = eduLevel.getText().toString();
        String linkOfClass = classLink.getText().toString();
        String linkOfExam = examLink.getText().toString();
        String classTime = timeOfClass.getText().toString();

        onlineClassExamDatabase = FirebaseDatabase.getInstance();
        onlineClassExamRef = onlineClassExamDatabase.getReference("OnlineClassExam").child(levelofEdu);

        onlineClassExamRef.child("Class").setValue(linkOfClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    dataSet = true;
                }else {
                    dataSet =false;
                }
            }
        });
        onlineClassExamRef.child("Exam").setValue(linkOfExam).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    dataSet = true;
                }else {
                    dataSet =false;
                }
            }
        });
        onlineClassExamRef.child("Time").setValue(classTime).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    dataSet = true;
                }else {
                    dataSet =false;
                }
            }
        });

        if(dataSet){
            Toast.makeText(getApplicationContext(),"Data is uploaded",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Data is not uploaded",Toast.LENGTH_SHORT).show();
        }


    }
}