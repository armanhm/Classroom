package com.example.testclassroom;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    static Person p;
    static String result = "";


    EditText editTextUsername, editTextPassword;
    Button buttonRegister;
    ImageView imageViewChoosePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextUsername = findViewById(R.id.editTextUsername2);
        editTextPassword = findViewById(R.id.editTextPassword2);
        buttonRegister = findViewById(R.id.buttonSignUp);
        imageViewChoosePicture = findViewById(R.id.imageViewChoosePicture);


        editTextPassword.setOnClickListener(v -> {
            if (!editTextUsername.getText().toString().equals("")) {
                String check = "userChecker:" + editTextUsername.getText().toString();
                TransferMessage transferMessage = new TransferMessage();
                transferMessage.execute(check);
                Toast.makeText(RegisterActivity.this, transferMessage.message, Toast.LENGTH_SHORT).show();
                while (result.equals("")) {
                    Log.e("the Result", result);
                    if (!result.equals("")) {
                        break;
                    }
                }
                if (result.equals("repeated")) {
                    RegisterActivity.result = "";
                    editTextUsername.requestFocus();
                    editTextUsername.setError("Repeated Username");
                }
            }
            else {
                editTextUsername.requestFocus();
                editTextUsername.setError("Please Enter Username");
            }
        });


        buttonRegister.setOnClickListener(v -> {
            new TransferMessage().execute("signUp:" + editTextUsername.getText().toString() + ":" + editTextPassword.getText().toString());
            WelcomeActivity.username = editTextUsername.getText().toString();
            while (result.equals("")){
                if(!result.equals("")){
                    break;
                }
            }
            if (result.equals("ERROR")){
                editTextUsername.requestFocus();
                editTextUsername.setError("repeated username");
            }
            else if (result.equals("SUCCESS")){
                Intent intent = new Intent(RegisterActivity.this,ChoosePictureActivity.class);
                startActivity(intent);
            }

            //******************************************************
            if (editTextUsername.getText().toString().equals("")) {
                editTextUsername.requestFocus();
                editTextUsername.setError("Please Enter Username");
            } else {
                String s = "signUp:" + editTextUsername.getText().toString() + ":" + editTextPassword.getText().toString();
                TransferMessage transferMessage = new TransferMessage();
                transferMessage.execute(s);
                while (!RegisterActivity.result.equals("SUCCESS")) {
                        Log.e("tagRegister", result);
                        RegisterActivity.result = "";
                        editTextUsername.requestFocus();
                        editTextUsername.setError("This Username is already Taken");

                }

                Log.e("tagRegister", result);
                RegisterActivity.result = "";
                WelcomeActivity.username = editTextUsername.getText().toString();
                p = new Person();
                p.setUsername(editTextUsername.getText().toString());
                p.setPassword(editTextPassword.getText().toString());
                Intent intent = new Intent(RegisterActivity.this, ListOfClassActivity.class);
                Toast.makeText(RegisterActivity.this, "Registered as " + editTextUsername.getText().toString(), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });



    }



}
