package com.example.testclassroom;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String type;
    Button buttonSignIn;
    Button buttonRegister;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    static ArrayList<String> classList = new ArrayList<>();
    static ArrayList<String> homeworkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListOfClassActivity.arrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
        });
        buttonRegister.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });



//        dl = (DrawerLayout)findViewById(R.id.activity_main);
//        t = new ActionBarDrawerToggle(this, dl,R.string.Open,R.string.Close);
//
//        dl.addDrawerListener(t);
//        t.syncState();
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        nv = (NavigationView)findViewById(R.id.nv);
//        nv.setNavigationItemSelectedListener(menuItem -> {
//            int id = menuItem.getItemId();
//            switch(id)
//            {
//                case R.id.account:
//                    Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();break;
//                case R.id.settings:
//                    Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();break;
//                case R.id.mycart:
//                    Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();break;
//                default:
//                    return true;
//            }
//
//
//            return true;
//
//        });

    }


}
