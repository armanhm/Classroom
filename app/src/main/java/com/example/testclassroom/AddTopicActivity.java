package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AddTopicActivity extends AppCompatActivity {
    static Spinner spinner;
    static String[] arraySpinner;
    static String[] arrayList;
    static ArrayList<String> result;
    static String topics = "";
    EditText editTextAddTopic;
    TextView textViewSaveTopic;
    static int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_topic);

        fillSpinner();

        spinner = findViewById(R.id.spinner_add_topic);
        editTextAddTopic = findViewById(R.id.editText_add_topic);
        textViewSaveTopic = findViewById(R.id.textView_send_topic);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        textViewSaveTopic.setOnClickListener(v -> {
            new TransferMessage().execute("addTopic:" + ListOfHomeworkActivity.classCode + ":" + editTextAddTopic.getText().toString());
            Toast.makeText(AddTopicActivity.this , "topic added successfully",Toast.LENGTH_SHORT).show();
            editTextAddTopic.setText("");
            new TransferMessage().execute("topics:" + ListOfHomeworkActivity.classCode);
            fillSpinner();
        });
    }

    public static void fillSpinner(){
        result = new ArrayList<>();
        arrayList = topics.split(":");
        arraySpinner = new String[length];
        for (int i = 0; i < arraySpinner.length; i++) {
            arraySpinner[i] = arrayList[i+2];
        }
    }
}

