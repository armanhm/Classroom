package com.example.testclassroom;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<ItemPeople> itemList;
    private PeopleAdapter.OnNoteListener onNoteListener;

    public PeopleAdapter(int listItemLayout, ArrayList<ItemPeople> itemList, PeopleAdapter.OnNoteListener onNoteListener) {
        this.listItemLayout = listItemLayout;
        this.itemList = itemList;
        this.onNoteListener = onNoteListener;
    }

    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        PeopleAdapter.ViewHolder myViewHolder = new PeopleAdapter.ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.ViewHolder viewHolder, int i) {
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
            textViewName = itemView.findViewById(R.id.textView_people_name);
            imageViewProfile = itemView.findViewById(R.id.image_profile_people);
            this.onNoteListener = onNoteListener;

        }
    }
}

