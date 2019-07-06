package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class ListOfInstructionsActivity extends AppCompatActivity {

    RecyclerView recyclerViewComments;
    TextView textViewDate ;
    TextView textViewTitle ;
    TextView textViewPoints ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_instructions);

        recyclerViewComments = findViewById(R.id.recyclerView_instructions);
        textViewDate = findViewById(R.id.textView_homework_date);
        textViewPoints = findViewById(R.id.textView_homework_point);
        textViewTitle = findViewById(R.id.textView_homework_title);



    }
}
