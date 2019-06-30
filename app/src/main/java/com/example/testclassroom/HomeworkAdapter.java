package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder> {


    public HomeworkAdapter(int layoutId, ArrayList<ItemClass> itemList, ItemArrayAdapter.OnNoteListener onNoteListener) {
        //listItemLayout = layoutId;
       // this.itemList = itemList;
        //this.onNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public HomeworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeworkAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

//*******************
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView className;
        public TextView numberOfStudent;
        ItemArrayAdapter.OnNoteListener onNoteListener;

        public ViewHolder(View itemView, ItemArrayAdapter.OnNoteListener onNoteListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            className = itemView.findViewById(R.id.textViewClassName);
            numberOfStudent = itemView.findViewById(R.id.textViewStudentNumbers);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    //***************

}
