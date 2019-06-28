package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        Log.e("User", WelcomeActivity.username);
        recyclerView = findViewById(R.id.recyclerViewClassNames);
        ArrayList<ItemClass> classList = RegisterActivity.p.getItemClasses();
        for (int i = 0; i < arrayList.size(); i++) {
            ItemClass itemClass = new ItemClass(arrayList.get(i),"5");
            classList.add(itemClass);
        }
        //Log.e("Taga",classList.get(1).getName());
        SendMessage sendMessage = new SendMessage();
        sendMessage.execute("classList:" + WelcomeActivity.username);
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item,classList);
        recyclerView = findViewById(R.id.recyclerViewClassNames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
    }
}
