package com.joy50.kendrobinduadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SetResultAdapter extends RecyclerView.Adapter<SetResultAdapter.ViewHolder> {

    private List<SetResultModel> setResultModelList;

    public SetResultAdapter(List<SetResultModel> setResultModelList) {
        this.setResultModelList = setResultModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_result_each,parent,false);
        return new SetResultAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String fileName = setResultModelList.get(position).getNameOfFile();
        String fileLink =setResultModelList.get(position).getLinkOfFile();
        ((ViewHolder)holder).setData(fileName,fileLink);
    }

    @Override
    public int getItemCount() {
        return setResultModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameOfFile;
        private ImageView deleteFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOfFile = itemView.findViewById(R.id.name_of_file);
            deleteFile = itemView.findViewById(R.id.delete_file);
            deleteFile.setVisibility(View.GONE);
        }

        void setData(String fileName,String fileLink){
            nameOfFile.setText(fileName);
            if(!fileLink.isEmpty()){
                deleteFile.setVisibility(View.VISIBLE);
            }
        }
    }
}
