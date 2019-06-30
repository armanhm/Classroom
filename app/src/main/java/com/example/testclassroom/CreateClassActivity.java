package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateClassActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextDescription;
    EditText editTextNumber;
    String name , description , number;
    String result = "createClass:";
    Button createClassButton , cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
        editTextName = findViewById(R.id.editTextClassName);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextNumber = findViewById(R.id.editTextNumber);
        createClassButton = findViewById(R.id.buttonCreateClass);
        cancelButton = findViewById(R.id.buttonCancel);
        createClassButton.setOnClickListener(v -> {
            name = editTextName.getText().toString();
            description = editTextDescription.getText().toString();
            number = editTextNumber.getText().toString();
            result = result.concat(WelcomeActivity.username + ":");
            result = result.concat(name + ":" + description + ":") ;
            result = result.concat(number) ;

            TransferMessage transferMessage = new TransferMessage();
            transferMessage.execute(result);
            Log.e("sendCreate",result);
            refreshList();

            Intent intent = new Intent(CreateClassActivity.this,ListOfClassActivity.class) ;
            startActivity(intent);
        });
        cancelButton.setOnClickListener(v -> {
           TransferMessage transferMessage = new TransferMessage();
            transferMessage.execute("error");
            Intent intent = new Intent(CreateClassActivity.this,ListOfClassActivity.class);
            startActivity(intent);
        });
    }
    public static void refreshList(){
        TransferMessage transferMessage = new TransferMessage();
        transferMessage.execute("classList:" + WelcomeActivity.username);
    }
}
