package com.joy50.kendrobindu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckResultAdapter extends RecyclerView.Adapter<CheckResultAdapter.ViewHolder> {

    private List<CheckResultModel> checkResultModelList;

    public CheckResultAdapter(List<CheckResultModel> checkResultModelList) {
        this.checkResultModelList = checkResultModelList;
    }

    @NonNull
    @Override
    public CheckResultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.results_each,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckResultAdapter.ViewHolder holder, int position) {
        String levelOfClass = checkResultModelList.get(position).getClassLevel();
        String downloadLink = checkResultModelList.get(position).getDownloadLink();
        ((CheckResultAdapter.ViewHolder)holder).setDataforDownload(levelOfClass,downloadLink);
    }

    @Override
    public int getItemCount() {
        return checkResultModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView classLevel;
        private ImageView downloadIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            classLevel = itemView.findViewById(R.id.result_for_class);
            downloadIcon = itemView.findViewById(R.id.download_file);
        }

        private void setDataforDownload(String levelofClass,String downloadLink){
            if(!downloadLink.isEmpty()){
                downloadIcon.setVisibility(View.VISIBLE);
                classLevel.setText(levelofClass);
            }
        }
    }
}
