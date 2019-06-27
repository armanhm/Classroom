package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class RegisterActivity extends AppCompatActivity {

    static Person p ;

    EditText username , password;
    Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editTextUsername2);
        password = findViewById(R.id.editTextPassword2);
        buttonRegister = findViewById(R.id.buttonSignUp);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String check = "userChecker:" + username.getText().toString();
                SendMessage sendMessage = new SendMessage();
                sendMessage.execute(check);
                Toast.makeText(RegisterActivity.this,sendMessage.message,Toast.LENGTH_SHORT).show();
            }
        });



        buttonRegister.setOnClickListener(v ->{
            WelcomeActivity.username = username.getText().toString();
            String s = "signUp:" + username.getText().toString()
            + ":" + password.getText().toString();
            p = new Person();
            p.setUsername(username.getText().toString());
            p.setPassword(password.getText().toString());
          SendMessage sendMessage = new SendMessage();
          sendMessage.execute(s);
            Intent intent = new Intent(RegisterActivity.this,ClassActivity.class);
            startActivity(intent);
        });
    }
}
