package com.joy50.kendrobinduadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SetOnlineClassExamAdapter extends RecyclerView.Adapter<SetOnlineClassExamAdapter.ViewHolder> {

    private List<SetOnlineClassExamModel> setOnlineClassExamModelList;

    public SetOnlineClassExamAdapter(List<SetOnlineClassExamModel> setOnlineClassExamModelList) {
        this.setOnlineClassExamModelList = setOnlineClassExamModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_online_class_exam_each,parent,false);
        return new SetOnlineClassExamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String levelOfClass = setOnlineClassExamModelList.get(position).getLevelOfClass();
        String linkOfClass = setOnlineClassExamModelList.get(position).getLinkForClass();
        String linkOfExam = setOnlineClassExamModelList.get(position).getLinkForExam();
        String timeOfClass = setOnlineClassExamModelList.get(position).getTimeSet();

        ((ViewHolder)holder).setAllDataForOnlineClassAndExam(levelOfClass,linkOfClass,linkOfExam,timeOfClass);

    }

    @Override
    public int getItemCount() {
        return setOnlineClassExamModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView lectureForClass;
        private TextView availableExamNotification;
        private TextView timeOfSetted;
        private ImageView deleteClass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lectureForClass = itemView.findViewById(R.id.lecture_for_class);
            availableExamNotification = itemView.findViewById(R.id.exam_today);
            timeOfSetted = itemView.findViewById(R.id.time_of_class);
            deleteClass = itemView.findViewById(R.id.delete_class);

            availableExamNotification.setVisibility(View.GONE);
            deleteClass.setVisibility(View.GONE);
        }

        void setAllDataForOnlineClassAndExam(String eduLevel,String linkForClass,String linkForExam,String timeForClass){
            if(!linkForClass.isEmpty() || !linkForExam.isEmpty()){
                if (!linkForExam.isEmpty()){

                    lectureForClass.setText(timeForClass);
                    availableExamNotification.setVisibility(View.VISIBLE);
                    timeOfSetted.setText(timeForClass);
                    deleteClass.setVisibility(View.VISIBLE);
                }else {
                    lectureForClass.setText(eduLevel);
                    availableExamNotification.setVisibility(View.GONE);
                    timeOfSetted.setText(timeForClass);
                    deleteClass.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
