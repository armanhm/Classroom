package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinClassActivity extends AppCompatActivity {

    static EditText editTextCode;
    Button button;
    String code;
    static String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_class);
        editTextCode = findViewById(R.id.editTextCode);
        button = findViewById(R.id.buttonJoinClass);
        button.setOnClickListener(v -> {
            code = editTextCode.getText().toString();
            TransferMessage transferMessage = new TransferMessage();
            transferMessage.execute("joinClass:" + WelcomeActivity.username + ":" + code);
            if (result.equals("success")){
                Intent intent = new Intent(JoinClassActivity.this,ListOfClassActivity.class);
                startActivity(intent);
                CreateClassActivity.refreshList();
                Toast.makeText(JoinClassActivity.this,"successfully joined",Toast.LENGTH_SHORT).show();

            }
            // joinClass:username:code
        });
    }
}
