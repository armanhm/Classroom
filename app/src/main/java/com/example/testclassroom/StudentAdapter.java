package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<ItemStudent> itemList;
    private StudentAdapter.OnNoteListener onNoteListener;

    public StudentAdapter(int listItemLayout, ArrayList<ItemStudent> itemList, StudentAdapter.OnNoteListener onNoteListener) {
        this.listItemLayout = listItemLayout;
        this.itemList = itemList;
        this.onNoteListener = onNoteListener;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        StudentAdapter.ViewHolder myViewHolder = new StudentAdapter.ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder viewHolder, int i) {
        TextView textViewName = viewHolder.textViewName;
        //ImageView imageViewProfile = viewHolder.imageViewProfile ;
        textViewName.setText(itemList.get(i).getUsername());
        //imageViewProfile.setImageURI(itemList.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName ;
        ImageView imageViewProfile ;
        OnNoteListener onNoteListener;


        public ViewHolder(@NonNull View itemView , OnNoteListener onNoteListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_student_name);
            imageViewProfile = itemView.findViewById(R.id.image_profile_student);
            this.onNoteListener = onNoteListener;

        }
    }
}

