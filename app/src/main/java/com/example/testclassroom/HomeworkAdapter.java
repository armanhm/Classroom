package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder> {
    private int listItemLayout;
    private ArrayList<ItemHomework> itemHomework;
    private HomeworkAdapter.OnNoteListener onNoteListener;

    public HomeworkAdapter(int layoutId, ArrayList<ItemHomework> itemHomeworks, HomeworkAdapter.OnNoteListener onNoteListener) {
        listItemLayout = layoutId;
        this.itemHomework = itemHomeworks;
        this.onNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public HomeworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        HomeworkAdapter.ViewHolder myViewHolder = new HomeworkAdapter.ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeworkAdapter.ViewHolder viewHolder, int i) {
        TextView homeworkName = viewHolder.homeworkName;
        TextView numberOfComments = viewHolder.numberOfComments;
        TextView dateOfPost = viewHolder.dateOfPost;
        homeworkName.setText(itemHomework.get(i).getName());
        numberOfComments.setText(itemHomework.get(i).getNumberOfComments());
        dateOfPost.setText(itemHomework.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return itemHomework == null ? 0 : itemHomework.size();
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }


//*******************
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView homeworkName;
        public TextView dateOfPost;
        public TextView numberOfComments;
        OnNoteListener onNoteListener;

        public ViewHolder(View itemView, HomeworkAdapter.OnNoteListener onNoteListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            homeworkName = itemView.findViewById(R.id.textViewHomeworkName);
            numberOfComments = itemView.findViewById(R.id.textViewNumberOfComments);
            dateOfPost = itemView.findViewById(R.id.textViewPostDate);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    //***************

}
