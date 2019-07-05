package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {
    private int layoutId;
    private ArrayList<ItemTeacher> itemTeachers;
    private OnNoteListener onNoteListener;

    public TeacherAdapter(int layoutId, ArrayList<ItemTeacher> itemTeachers, OnNoteListener onNoteListener) {
        this.layoutId = layoutId;
        this.itemTeachers = itemTeachers;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public TeacherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId , viewGroup , false);
        TeacherAdapter.ViewHolder myViewHolder = new TeacherAdapter.ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherAdapter.ViewHolder viewHolder, int i) {
        TextView textViewName = viewHolder.textViewName;
        textViewName.setText(itemTeachers.get(i).getUsername());
        //ImageView imageViewProfile = viewHolder.imageViewProfile;
        //imageViewProfile.setImageURI(itemTeachers.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return itemTeachers == null ? 0 : itemTeachers.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName ;
        ImageView imageViewProfile ;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView , OnNoteListener onNoteListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_teacher_name);
            imageViewProfile = itemView.findViewById(R.id.image_profile_teacher);
        }
    }
}
