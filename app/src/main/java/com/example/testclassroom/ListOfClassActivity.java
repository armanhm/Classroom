package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfClassActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class);
        TransferMessage transferMessage = new TransferMessage();
        transferMessage.execute("classList:" + WelcomeActivity.username);
        if (WelcomeActivity.classList.size() != 0) {
            Log.e("Transfer", WelcomeActivity.classList.get(0));
        }
        recyclerView = findViewById(R.id.recyclerViewClassNames);
        ArrayList<ItemClass> classList = RegisterActivity.p.getItemClasses();
        for (int i = 0; i < WelcomeActivity.classList.size()-1; i++) {
            ItemClass itemClass = new ItemClass(WelcomeActivity.classList.get(i) , WelcomeActivity.classList.get(i+1));
            classList.add(itemClass);
        }
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item,classList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_or_join_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItem itemJoin , itemCreate;
        itemJoin = findViewById(R.id.action_join);
        itemCreate = findViewById(R.id.action_create);
        int id = item.getItemId();

        if (id == R.id.action_join){
            Intent intent = new Intent(ListOfClassActivity.this,JoinClassActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_create){
            Intent intent = new Intent(ListOfClassActivity.this,CreateClassActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
