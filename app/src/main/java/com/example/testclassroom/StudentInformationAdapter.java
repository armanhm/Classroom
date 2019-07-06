package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentInformationAdapter extends RecyclerView.Adapter<StudentInformationAdapter.ViewHolder> {
    int layoutId;
    ArrayList<ItemInformation> itemInformations;

    public StudentInformationAdapter(int layoutId, ArrayList<ItemInformation> itemInformations) {
        this.layoutId = layoutId;
        this.itemInformations = itemInformations;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TextView textViewName = viewHolder.textViewName;
        TextView textViewGrade = viewHolder.textViewGrade;
        textViewName.setText(itemInformations.get(i).getHomeworkName());
        textViewGrade.setText(itemInformations.get(i).getGrade());
    }

    @Override
    public int getItemCount() {
        return itemInformations == null ? 0 : itemInformations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName , textViewGrade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_name_info);
            textViewGrade = itemView.findViewById(R.id.textView_grade_info);
        }
    }
}
