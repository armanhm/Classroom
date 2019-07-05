package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClassSettingActivity extends AppCompatActivity {
    TextView textViewTitle ,textViewDescription , textViewRoomNumber , textViewClassCode;
    EditText editTextTitle , editTextDescription , editTextRoomNumber;
    static String result = "";
    String request = "classSetting:" ;
    String title, description, roomNUmber , classCode ;
    String newTitle, newDescription , newRoomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //updateClassInfo(classCode);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_setting);

        String [] classInformation = result.split(":");
        title = classInformation[1] ;
        description = classInformation[2];
        roomNUmber = classInformation[3];
        classCode = classInformation[4];

        textViewTitle = findViewById(R.id.textView_class_title);
        textViewDescription = findViewById(R.id.textView_class_description);
        textViewRoomNumber = findViewById(R.id.textView_class_room);
        textViewClassCode = findViewById(R.id.textView_class_code2);

        editTextTitle = findViewById(R.id.editText_class_title);
        editTextDescription = findViewById(R.id.editText_class_description);
        editTextRoomNumber = findViewById(R.id.editText_class_room);

        editTextTitle.setText(title);
        editTextDescription.setText(description);
        editTextRoomNumber.setText(roomNUmber);
        textViewClassCode.setText(classCode);


    }

    public static void updateClassInfo(String classCode) {
        new TransferMessage().execute("classInfo:" + classCode);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        newTitle = editTextTitle.getText().toString().equals("") ? "noTitle" : editTextTitle.getText().toString();
        newDescription = editTextDescription.getText().toString().equals("") ? "noDescription" : editTextDescription.getText().toString();
        newRoomNumber = editTextRoomNumber.getText().toString().equals("") ? "noRoomNumber" : editTextRoomNumber.getText().toString();

        int id = item.getItemId();
        if(id == R.id.action_save_class_setting){
            request = request.concat(classCode + ":" + newTitle + ":" + newDescription + ":" + newRoomNumber);
            new TransferMessage().execute(request);
            Toast.makeText(this,"The changes successfully saved!" , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSettingActivity.this,ListOfHomeworkActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
