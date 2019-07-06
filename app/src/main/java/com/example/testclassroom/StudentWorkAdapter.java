package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentWorkAdapter extends RecyclerView.Adapter<StudentWorkAdapter.ViewHolder> {

    private int layoutId ;
    private ArrayList <ItemStudentWork> studentWorks ;
    private OnNoteListener onNoteListener;


    public StudentWorkAdapter(int layoutId, ArrayList<ItemStudentWork> studentWorks, OnNoteListener onNoteListener) {
        this.layoutId = layoutId;
        this.studentWorks = studentWorks;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ImageView imageViewProile = viewHolder.imageViewProfile ;
        TextView textViewName = viewHolder.textViewName ;
        TextView textViewPoints = viewHolder.textViewPoint ;
        textViewName.setText(studentWorks.get(i).getName());
        textViewPoints.setText(studentWorks.get(i).getPoint());
//        imageViewProile.setImageURI();
    }

    @Override
    public int getItemCount() {
        return studentWorks == null ? 0 : studentWorks.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageViewProfile ;
        TextView textViewName ;
        TextView textViewPoint ;
        OnNoteListener onNoteListener ;



        public ViewHolder(@NonNull View itemView , OnNoteListener onNoteListener) {
            super(itemView);
            this.onNoteListener = onNoteListener ;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
}
