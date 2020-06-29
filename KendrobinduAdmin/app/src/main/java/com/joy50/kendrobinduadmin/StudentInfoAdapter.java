package com.joy50.kendrobinduadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentInfoAdapter extends RecyclerView.Adapter<StudentInfoAdapter.ViewHolder> {

    private List<StudentsInfoModel> studentsInfoModelList;

    public StudentInfoAdapter(List<StudentsInfoModel> studentsInfoModelList) {
        this.studentsInfoModelList = studentsInfoModelList;
    }

    @NonNull
    @Override
    public StudentInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_students_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentInfoAdapter.ViewHolder holder, int position) {

        String nameofStudent = studentsInfoModelList.get(position).getStudentName();
        String levelofStudy = studentsInfoModelList.get(position).getStudyLevel();
        ((StudentInfoAdapter.ViewHolder)holder).setNameAndStudyLevel(nameofStudent,levelofStudy);
    }

    @Override
    public int getItemCount() {
        return studentsInfoModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameOfStudent;
        private TextView levelOfStudy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOfStudent = itemView.findViewById(R.id.name_of_student);
            levelOfStudy = itemView.findViewById(R.id.study_level_of_student);
        }

        void setNameAndStudyLevel(String studentName,String studyLevel){
            nameOfStudent.setText(studentName);
            levelOfStudy.setText(studyLevel);
        }
    }
}
