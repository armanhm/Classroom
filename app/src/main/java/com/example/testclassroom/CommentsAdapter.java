package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private int layout ;
    private ArrayList<ItemComment> itemComments ;

    public CommentsAdapter(int layout, ArrayList<ItemComment> itemComments) {
        this.layout = layout;
        this.itemComments = itemComments;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder commentsAdapter, int i) {
        TextView textViewComments = commentsAdapter.textViewComment;
        TextView textViewUsrname = commentsAdapter.textViewUsername ;
        textViewComments.setText(itemComments.get(i).getComment());
        textViewUsrname.setText(itemComments.get(i).getUsername());
    }

    @Override
    public int getItemCount() {
        return itemComments == null ? 0 : itemComments.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewComment ;
        public TextView textViewUsername ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewComment = itemView.findViewById(R.id.textViewComment);
            textViewUsername = itemView.findViewById(R.id.textView_username_comment);
        }
    }
}
