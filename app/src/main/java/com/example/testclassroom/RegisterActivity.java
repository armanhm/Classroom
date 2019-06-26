package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText username , password;
    Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.editTextUsername2);
        password = findViewById(R.id.editTextPassword2);
        buttonRegister = findViewById(R.id.buttonSignUp);
        buttonRegister.setOnClickListener(v ->{
            String s = "signUp:" + username.getText().toString()
            + ":" + password.getText().toString();
          SendMessage sendMessage = new SendMessage();
          sendMessage.execute(s);
        });
    }
}
