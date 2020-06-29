package com.joy50.kendrobindu;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnlineClassAdapter extends RecyclerView.Adapter<OnlineClassAdapter.ViewHolder> {

    private List<OnlineClassModel> onlineClassModelList;

    public OnlineClassAdapter(List<OnlineClassModel> onlineClassModelList) {
        this.onlineClassModelList = onlineClassModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.online_class_each,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String levelOfEdu = onlineClassModelList.get(position).getEducationLevel();
        String timeofEdu = onlineClassModelList.get(position).getEducationTime();
        String linkOfEdu = onlineClassModelList.get(position).getClassLink();
        ((ViewHolder)holder).setDataInView(levelOfEdu,timeofEdu,linkOfEdu);
    }

    @Override
    public int getItemCount() {
        return onlineClassModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView eduLevel;
        public TextView eduTime;
        public TextView eduLink;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eduLevel = (itemView).findViewById(R.id.edu_level);
            eduTime = (itemView).findViewById(R.id.edu_time);
            eduLink = (itemView).findViewById(R.id.edu_link);
        }

        private void setDataInView(String levelOfEdu,String timeofEdu,String linkOfEdu){
            eduLevel.setText(levelOfEdu);
            eduTime.setText(timeofEdu);
            eduLink.setText(linkOfEdu);
        }
    }
}
