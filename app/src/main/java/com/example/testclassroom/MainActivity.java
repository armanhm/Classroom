package com.example.testclassroom;

import android.content.Intent;
import android.graphics.Point;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String type;
    Button buttonSignIn;
    Button buttonRegister;
    ImageView imageViewSignIn , imageViewSignUp;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    static ArrayList<String> classList = new ArrayList<>();
    static int width , height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        Log.e("Width", "" + width);
        Log.e("height", "" + height);
        Toast.makeText(MainActivity.this , "width:" + width + "  height:" + height , Toast.LENGTH_LONG).show();


        ListOfClassActivity.arrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewSignIn = findViewById(R.id.imageView_signIn);
        imageViewSignUp = findViewById(R.id.imageView_Register);


        imageViewSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SignInActivity.class);
            startActivity(intent);
        });

        imageViewSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });


        ItemClass.classCodes = new ArrayList<>();



//        dl = (DrawerLayout)findViewById(R.id.activity_main);
//        t = new ActionBarDrawerToggle(this, dl,R.request.Open,R.request.Close);
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
