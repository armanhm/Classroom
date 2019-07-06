package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class NotificationActivity extends AppCompatActivity  implements NotificationAdapter.OnNoteListener{
    RecyclerView recyclerViewNotifications;
    static ArrayList<String> arrayListNotification;
    ArrayList<ItemNotification> notificationList;
    static String listOfNotification =  "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toast.makeText(NotificationActivity.this,"Notification",Toast.LENGTH_SHORT).show();

        arrayListNotification = new ArrayList<>();

        String[] s = listOfNotification.split(":");
        arrayListNotification.addAll(Arrays.asList(s));

        recyclerViewNotifications = findViewById(R.id.recyclerView_notifications);

        notificationList = new ArrayList<>();

        for (int i = 2; i < arrayListNotification.size(); i += 2) {
            ItemNotification itemNotification = new ItemNotification(arrayListNotification.get(i) , arrayListNotification.get(i+1));
            notificationList.add(itemNotification);
        }

        NotificationAdapter notificationAdapter = new NotificationAdapter(R.layout.item_notification , notificationList , this);
        recyclerViewNotifications.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotifications.setItemAnimator(new DefaultItemAnimator());
        recyclerViewNotifications.setAdapter(notificationAdapter);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onNoteClick(int position) {
//        ItemHomework itemHomework = homeworkList.get(position);
//        Intent intent = new Intent(ListOfHomeworkActivity.this, ProfileHomeworkStudentActivity.class);
//        intent.putExtra("homeworkName", itemHomework.getName());
//        intent.putExtra("homeworkCode" , ItemHomework.homeworkCodes.get(position));
//        startActivity(intent);

    }
}
