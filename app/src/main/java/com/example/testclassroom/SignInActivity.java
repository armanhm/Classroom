package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {
    static String msg = "android";
    EditText username , password;
    Button buttonSignIn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        buttonSignIn = findViewById(R.id.buttonSignIn2);
        textView = findViewById(R.id.tvTest);

        buttonSignIn.setOnClickListener(v ->{
            String s = "signIn:" + username.getText().toString()
                    + ":" + password.getText().toString();
            SendMessage sendMessage = new SendMessage();
            sendMessage.execute(s);
            WelcomeActivity.username = username.getText().toString();
            textView.setText(msg);
        });


//        username.setOnFocusChangeListener((v, hasFocus) -> {
//            String check = "userChecker:" + username.getText().toString();
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.execute(check);
//        });
    }
}
