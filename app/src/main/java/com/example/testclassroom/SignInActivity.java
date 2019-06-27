package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    EditText username , password;
    Button buttonSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn2);

        buttonSignIn.setOnClickListener(v ->{
            String s = "signIn:" + username.getText().toString()
                    + ":" + password.getText().toString();
            SendMessage sendMessage = new SendMessage();
            sendMessage.execute(s);
            //receive
            WelcomeActivity.username = username.getText().toString();
        });


//        username.setOnFocusChangeListener((v, hasFocus) -> {
//            String check = "userChecker:" + username.getText().toString();
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.execute(check);
//        });
    }
}
