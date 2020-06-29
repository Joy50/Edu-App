package com.joy50.kendrobinduadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class SetResultActivity extends AppCompatActivity {

    private RecyclerView uploadedClassRecyclerView;
    private EditText filePath;
    private EditText fileName;
    private ImageView uploadFile;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseStorage firebaseStorage;
    private Uri fileUri;
    private ProgressDialog progressDialog;
    private List<SetResultModel> setResultModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_result);

        filePath = findViewById(R.id.file_path);
        fileName = findViewById(R.id.file_name);
        uploadFile = findViewById(R.id.upload_result);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        filePath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    selectPdf();
                }else {
                    ActivityCompat.requestPermissions(SetResultActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fileUri != null){
                    uploadPdf(fileUri);
                }else {
                    Toast.makeText(getApplicationContext(),"Select A file",Toast.LENGTH_SHORT).show();
                }
            }
        });

        uploadedClassRecyclerView = findViewById(R.id.uploaded_result_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        uploadedClassRecyclerView.setLayoutManager(layoutManager);
        uploadedClassRecyclerView.setHasFixedSize(true);

        //List<SetResultModel> setResultModelList = new ArrayList<>();

        ///opening///
        setResultModelList = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String fileName = snapshot.getKey();
                String downloadLink = snapshot.getValue(String.class);
                setResultModelList.add(new SetResultModel(fileName,downloadLink));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ///Ending///
        /*setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));
        setResultModelList.add(new SetResultModel("Result of class 5","www.facebook.com"));*/
        SetResultAdapter setResultAdapter = new SetResultAdapter(setResultModelList);
        uploadedClassRecyclerView.setAdapter(setResultAdapter);
        setResultAdapter.notifyDataSetChanged();
    }

    private void uploadPdf(Uri fileUri) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File");
        progressDialog.setProgress(0);
        progressDialog.show();

        StorageReference storageReference = firebaseStorage.getReference();
        final String nameOfFile = fileName.getText().toString();
        storageReference.child("Results").child(nameOfFile).putFile(fileUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String url = taskSnapshot.getUploadSessionUri().toString();
                        DatabaseReference databaseReference = firebaseDatabase.getReference();
                        databaseReference.child(nameOfFile).setValue(url)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(getApplicationContext(),"File is uploaded successfully",Toast.LENGTH_SHORT).show();
                                        }else {
                                            Toast.makeText(getApplicationContext(),"File is not uploaded successfully",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"File is not uploaded successfully",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int) ((int)100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setTitle(currentProgress);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            selectPdf();
        }else {
            Toast.makeText(getApplicationContext(),"Permission is not granted",Toast.LENGTH_SHORT).show();
        }
    }

    private void selectPdf() {
        Intent intent = new Intent();
        intent.setType("Application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 86 && resultCode == RESULT_OK && data != null){
            fileUri = data.getData();
        }else {
            Toast.makeText(getApplicationContext(),"Please Select A file",Toast.LENGTH_SHORT).show();
        }
    }
}