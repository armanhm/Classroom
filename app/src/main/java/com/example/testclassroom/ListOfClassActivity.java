package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ListOfClassActivity extends AppCompatActivity implements ItemArrayAdapter.OnNoteListener {
    RecyclerView recyclerView;
    static ArrayList<String> arrayList;
    static String listString = "";
    static String classCode = "";
    ArrayList<ItemClass> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        arrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateClassActivity.refreshList();


        if (!classCode.equals("")){
            Toast.makeText(ListOfClassActivity.this,"Class Code : "+classCode,Toast.LENGTH_LONG).show();
            classCode = "";
        }

//        TransferMessage transferMessage = new TransferMessage();
//        transferMessage.execute("classList:" + WelcomeActivity.username) ;

        String[] s = listString.split(":");
        for (int i = 1; i < s.length; i++) {
            arrayList.add(s[i]);
        }

        recyclerView = findViewById(R.id.recyclerViewClassNames);

        classList = new ArrayList<>();
        for (int i = 0; i < arrayList.size()-1; i += 2) {
            ItemClass itemClass = new ItemClass(arrayList.get(i) , arrayList.get(i+1));
            classList.add(itemClass);
        }
        RegisterActivity.p.setItemClasses(classList);
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item,RegisterActivity.p.getItemClasses(),this);
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
        else if (id == R.id.action_refresh_list){
            Intent intent = new Intent(ListOfClassActivity.this,ListOfClassActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoteClick(int position) {
        ItemClass itemClass = classList.get(position);
        Intent intent = new Intent(ListOfClassActivity.this,ClassActivity.class);
        intent.putExtra("className",itemClass.getName());
        intent.putExtra("classNumber",itemClass.getNumberOfStudent());
        Toast.makeText(ListOfClassActivity.this,"class name: " + itemClass.getName(),Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}
