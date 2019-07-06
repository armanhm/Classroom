package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InstructionAdapter extends RecyclerView.Adapter<InstructionAdapter.ViewHolder> {

    int layoutId;
    ArrayList<ItemComment> itemComments;
    OnNoteListener onNoteListener;

    public InstructionAdapter(int layoutId, ArrayList<ItemComment> itemComments, OnNoteListener onNoteListener) {
        this.layoutId = layoutId;
        this.itemComments = itemComments;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        InstructionAdapter.ViewHolder myViewHolder = new InstructionAdapter.ViewHolder(view, onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TextView textViewUsername = viewHolder.textView_username_instruction ;
        TextView textViewComment = viewHolder.textView_comment_instruction ;
        ImageView imageViewProfileInstruction = viewHolder.imageView_profile_instruction ;

        textViewUsername.setText(itemComments.get(i).getUsername());
        textViewComment.setText(itemComments.get(i).getComment());
        //imageViewProfileInstruction.setImageURI();
    }

    @Override
    public int getItemCount() {
        return itemComments == null ? 0 : itemComments.size();
    }


    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        OnNoteListener onNoteListener ;
        ImageView imageView_profile_instruction ;
        TextView textView_comment_instruction ;
        TextView textView_username_instruction ;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            this.onNoteListener = onNoteListener ;
            imageView_profile_instruction = itemView.findViewById(R.id.imageView_profile_instruction);
            textView_comment_instruction = itemView.findViewById(R.id.textView_comment_instruction);
            textView_username_instruction = itemView.findViewById(R.id.textView_username_comment_instruction);

        }
    }
}
