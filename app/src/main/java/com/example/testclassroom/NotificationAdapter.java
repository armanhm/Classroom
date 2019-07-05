package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private int layoutId;
    private ArrayList<ItemNotification> itemNotifications;
    private OnNoteListener onNoteListener;


    public NotificationAdapter(int layoutId, ArrayList<ItemNotification> itemNotifications, OnNoteListener onNoteListener) {
        this.layoutId = layoutId;
        this.itemNotifications = itemNotifications;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layoutId, viewGroup, false);
        ViewHolder myViewHolder = new ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder viewHolder, int i) {
       // TextView textViewUsername = viewHolder;
        //TextView textViewMessage = viewHolder;


    }

    @Override
    public int getItemCount() {
        return itemNotifications == null ? 0 : itemNotifications.size();
    }


    public interface OnNoteListener {
        void onNoteClick(int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewUsername;
        public TextView textViewMessage;
        OnNoteListener onNoteListener;


        public ViewHolder(@NonNull View itemView , OnNoteListener onNoteListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewUsername = itemView.findViewById(R.id.username_notification);
            textViewMessage = itemView.findViewById(R.id.message_notification);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

}

