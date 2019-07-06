package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfClassActivity extends AppCompatActivity implements ItemArrayAdapter.OnNoteListener {
    RecyclerView recyclerView;
    static ArrayList<String> arrayList;
    static String listString = "";
    static String classCode = "";
    static Class c;
    ArrayList<ItemClass> classList;
    static ItemArrayAdapter itemArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        arrayList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_class);

        CreateClassActivity.refreshList();

        if (!classCode.equals("")){
            Toast.makeText(ListOfClassActivity.this,"Class Code : "+classCode,Toast.LENGTH_LONG).show();
        }


        //listString is result of server
        String[] s = listString.split(":");
        arrayList.addAll(Arrays.asList(s).subList(1, s.length));

        recyclerView = findViewById(R.id.recyclerViewClassNames);

        classList = new ArrayList<>();
        for (int i = 0; i < arrayList.size()-1; i += 3) {
            ItemClass itemClass = new ItemClass(arrayList.get(i) , arrayList.get(i+1));
            ItemClass.classCodes.add(arrayList.get(i+2));
            classList.add(itemClass);
        }

        itemArrayAdapter = new ItemArrayAdapter(R.layout.item_class,classList,this);
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
            new TransferMessage().execute("classList:" + WelcomeActivity.username);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Intent intent = new Intent(ListOfClassActivity.this,ListOfClassActivity.class);
            startActivity(intent);
        }
        else if(id == R.id.action_sign_out){
            Intent intent = new Intent(ListOfClassActivity.this,MainActivity.class) ;
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNoteClick(int position) {
        ItemClass itemClass = classList.get(position);

        Intent intent = new Intent(ListOfClassActivity.this,ListOfHomeworkActivity.class);

         new TransferMessage().execute("homeworkList:" + ItemClass.classCodes.get(position) + ":" + WelcomeActivity.username);

        intent.putExtra("classCode" , ItemClass.classCodes.get(position));

        ListOfHomeworkActivity.classCode = ItemClass.classCodes.get(position);
        Log.e("ListOfClassCode" , ListOfHomeworkActivity.classCode);

        CreateHomeworkActivity.classCode = classCode;
        c = new Class(RegisterActivity.p,itemClass.getName(),"description",itemClass.getNumberOfStudent());
        Toast.makeText(ListOfClassActivity.this,"class title: " + itemClass.getName(),Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

}
