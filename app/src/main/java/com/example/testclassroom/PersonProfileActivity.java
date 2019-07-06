package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonProfileActivity extends AppCompatActivity {
    RecyclerView recyclerViewHomework;
    static ArrayList<String> arrayList;
    static String listString = "";
    ArrayList<ItemInformation> information;
    static StudentInformationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);

        arrayList = new ArrayList<>();

        recyclerViewHomework = findViewById(R.id.recyclerView_points);

        String[] s = listString.split(":");
        arrayList.addAll(Arrays.asList(s).subList(1,s.length));

        information = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i += 2) {
            ItemInformation itemInformation = new ItemInformation(arrayList.get(i),arrayList.get(i+1));
            information.add(itemInformation);
        }

        adapter = new StudentInformationAdapter(R.layout.item_information , information);
        recyclerViewHomework.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHomework.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHomework.setAdapter(adapter);

    }
}
