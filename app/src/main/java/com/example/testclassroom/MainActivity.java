package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String type;
    Button buttonSignIn;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);
        });
        buttonRegister.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(intent);
        });

    }


}
