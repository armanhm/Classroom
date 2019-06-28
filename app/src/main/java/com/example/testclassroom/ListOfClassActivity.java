package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ListOfClassActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class);
        Log.e("User", WelcomeActivity.username);
        recyclerView = findViewById(R.id.recyclerViewClassNames);
        ArrayList<ItemClass> classList = RegisterActivity.p.getItemClasses();
        for (int i = 0; i < arrayList.size(); i++) {
            Class c = TransferMessage.classes.get(i);
            ItemClass itemClass = new ItemClass(c.getName(),c.getNumber());
            classList.add(itemClass);
        }
        //Log.e("TAGA",TransferMessage.classes.get(0).getName());
        TransferMessage transferMessage = new TransferMessage();
        transferMessage.execute("classList:" + WelcomeActivity.username);
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item,classList);
        recyclerView = findViewById(R.id.recyclerViewClassNames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
    }
}
