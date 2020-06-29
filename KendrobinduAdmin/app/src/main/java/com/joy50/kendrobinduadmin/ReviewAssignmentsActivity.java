package com.joy50.kendrobinduadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ReviewAssignmentsActivity extends AppCompatActivity {

    private RecyclerView assignmentRecyclerView;
    private List<ReviewAssignmentModel> reviewAssignmentModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_assignments);

        assignmentRecyclerView = findViewById(R.id.assignments_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        assignmentRecyclerView.setLayoutManager(layoutManager);
        assignmentRecyclerView.setHasFixedSize(true);

        reviewAssignmentModelList = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String fileName = snapshot.getKey();
                String downloadLink = snapshot.getValue(String.class);
                reviewAssignmentModelList.add(new ReviewAssignmentModel(fileName,downloadLink));
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
        /*reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));
        reviewAssignmentModelList.add(new ReviewAssignmentModel("Physics class 7","www.facebook.com"));*/

        ReviewAssignmentAdapter assignmentAdapter = new ReviewAssignmentAdapter(reviewAssignmentModelList);
        assignmentRecyclerView.setAdapter(assignmentAdapter);
        assignmentAdapter.notifyDataSetChanged();
    }
}