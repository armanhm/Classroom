package com.example.testclassroom;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {
        RecyclerView recyclerView;
    static ArrayList<String> arrayList;
    static String listString = "";
    static String classCode = "";
    ArrayList<ItemHomework> homeworkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        arrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CreateClassActivity.refreshList();


        String[] s = listString.split(":");
        for (int i = 1; i < s.length; i++) {
            arrayList.add(s[i]);
        }

        recyclerView = findViewById(R.id.recyclerViewClassNames);

        homeworkList = new ArrayList<>();
        for (int i = 0; i < arrayList.size()-1; i += 2) {
            ItemHomework itemHomework = new ItemHomework(arrayList.get(i) , arrayList.get(i+1), arrayList.get(i+2));
            homeworkList.add(itemHomework);
        }
        //ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.item_class,RegisterActivity.p.getItemClasses(),this);
        //HomeworkAdapter homeworkAdapter = new HomeworkAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(homeworkAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_or_join_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItem itemJoin , itemCreate;
        itemJoin = findViewById(R.id.action_join);
        itemCreate = findViewById(R.id.action_create);
        int id = item.getItemId();

//        if (id == R.id.action_join){
//            Intent intent = new Intent(ListOfClassActivity.this,JoinClassActivity.class);
//            startActivity(intent);
//        }
//        else if(id == R.id.action_create){
//            Intent intent = new Intent(ListOfClassActivity.this,CreateClassActivity.class);
//            startActivity(intent);
//        }
//        else if (id == R.id.action_refresh_list){
//            Intent intent = new Intent(ListOfClassActivity.this,ListOfClassActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onNoteClick(int position) {
//        ItemClass itemClass = classList.get(position);
//        Intent intent = new Intent(ListOfClassActivity.this,ClassActivity.class);
//        intent.putExtra("className",itemClass.getName());
//        intent.putExtra("classNumber",itemClass.getNumberOfStudent());
//        Toast.makeText(ListOfClassActivity.this,"class title: " + itemClass.getName(),Toast.LENGTH_LONG).show();
//        startActivity(intent);
//
//    }
}
