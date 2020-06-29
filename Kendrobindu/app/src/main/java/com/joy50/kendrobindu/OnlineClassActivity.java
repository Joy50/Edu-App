package com.joy50.kendrobindu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class OnlineClassActivity extends AppCompatActivity {

    private RecyclerView onlineClassRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_class);

        getSupportActionBar().setTitle("Online Class");

        onlineClassRecyclerView = findViewById(R.id.onlineclassrecyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        onlineClassRecyclerView.setLayoutManager(layoutManager);
        onlineClassRecyclerView.setHasFixedSize(true);


        List<OnlineClassModel> onlineClassModelList = new ArrayList<>();

        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));
        onlineClassModelList.add(new OnlineClassModel("Class 6","11:58 PM","www.facebook.com"));

        OnlineClassAdapter onlineClassAdapter = new OnlineClassAdapter(onlineClassModelList);
        onlineClassRecyclerView.setAdapter(onlineClassAdapter);
        onlineClassAdapter.notifyDataSetChanged();
    }
}