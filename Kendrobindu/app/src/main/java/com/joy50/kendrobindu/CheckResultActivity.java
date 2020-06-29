package com.joy50.kendrobindu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CheckResultActivity extends AppCompatActivity {

    private RecyclerView checkResultRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_result);

        checkResultRecyclerView = findViewById(R.id.check_result_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        checkResultRecyclerView.setLayoutManager(layoutManager);
        checkResultRecyclerView.setHasFixedSize(true);

        List<CheckResultModel> resultModelList = new ArrayList<>();
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));
        resultModelList.add(new CheckResultModel("Result of Class 10.","www.facebook.com"));

        CheckResultAdapter checkResultAdapter = new CheckResultAdapter(resultModelList);
        checkResultRecyclerView.setAdapter(checkResultAdapter);
        checkResultAdapter.notifyDataSetChanged();
    }
}