package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinClassActivity extends AppCompatActivity {

    EditText editTextCode;
    Button button;
    String code = "";
    static String result = "";
    static String className = "";


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
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e("request >>>" ,result) ;
                if (result.equals("success")) {
                    CreateClassActivity.refreshList();
                    Intent intent = new Intent(JoinClassActivity.this, ListOfClassActivity.class);
                    startActivity(intent);
                    Toast.makeText(JoinClassActivity.this, "successfully joined to class" + className, Toast.LENGTH_SHORT).show();
                    result = "";
                } else if (result.equals("error")) {
                    editTextCode.setError("Wrong Class Code!");
                    result = "";
                } else if (code.equals("")) {
                    editTextCode.setError("Please enter code");
                }
            // joinClass:editTextUsername:code
        });
    }
}
