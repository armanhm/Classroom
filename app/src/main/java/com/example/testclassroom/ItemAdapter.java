package com.example.testclassroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<ItemClass> itemList;
    private OnNoteListener onNoteListener;

    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<ItemClass> itemList, OnNoteListener onNoteListener) {
        listItemLayout = layoutId;
        this.itemList = itemList;
        this.onNoteListener = onNoteListener;
    }

    public void updateList(ArrayList<ItemClass> items) {
        if (items != null && items.size() > 0) {
            itemList.clear();
            itemList.addAll(items);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view,onNoteListener);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView className = holder.className;
        TextView numberOfStudents = holder.numberOfStudent;
        className.setText(itemList.get(listPosition).getName());
        numberOfStudents.setText(itemList.get(listPosition).getNumberOfStudent());
    }

    public interface OnNoteListener {
        void onNoteClick(int position);
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView className;
        public TextView numberOfStudent;
        OnNoteListener onNoteListener;

        public ViewHolder(View itemView, OnNoteListener onNoteListener) {
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
}