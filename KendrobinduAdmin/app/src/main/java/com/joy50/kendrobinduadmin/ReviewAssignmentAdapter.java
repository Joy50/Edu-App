package com.joy50.kendrobinduadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAssignmentAdapter extends RecyclerView.Adapter<ReviewAssignmentAdapter.ViewHolder> {

    private List<ReviewAssignmentModel> reviewAssignmentModelList;

    public ReviewAssignmentAdapter(List<ReviewAssignmentModel> reviewAssignmentModelList) {
        this.reviewAssignmentModelList = reviewAssignmentModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_assignment_each,parent,false);
        return new ReviewAssignmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nameOfAssignmnet = reviewAssignmentModelList.get(position).getNameOfAssignment();
        String downloadLink = reviewAssignmentModelList.get(position).getDownloadLink();
        ((ViewHolder)holder).setAssignmentData(nameOfAssignmnet,downloadLink);
    }

    @Override
    public int getItemCount() {
        return reviewAssignmentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView assignmentName;
        private ImageView downloadButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            assignmentName = itemView.findViewById(R.id.assignment_name);
            downloadButton = itemView.findViewById(R.id.download_assignment);
        }

        void setAssignmentData(String nameOfAssignment,String downloadLink){

            //System.out.println(nameOfAssignment);
            if (!downloadLink.isEmpty()){
                assignmentName.setText(nameOfAssignment);
            }else {
                assignmentName.setText(nameOfAssignment);
                downloadButton.setVisibility(View.GONE);
            }
        }
    }
}
