package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    EditText username , password;
    Button buttonSignIn;
    TextView textView;
    static String result = "" ;

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
            TransferMessage transferMessage = new TransferMessage();
            transferMessage.execute(s);
            if (result.equals("SUCCESS")){
                SignInActivity.result = "" ;
                Intent intent = new Intent(SignInActivity.this , ListOfClassActivity.class);
                startActivity(intent);
            }
            else if(result.equals("ERROR")){
                username.requestFocus();
                username.setError("Wrong Username or Password");
                Toast.makeText(SignInActivity.this,"Try Again",Toast.LENGTH_LONG).show();
                SignInActivity.result = "" ;
            }
        });
    }
}
