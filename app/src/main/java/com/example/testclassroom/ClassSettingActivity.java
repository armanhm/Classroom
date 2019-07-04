package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ClassSettingActivity extends AppCompatActivity {
    TextView textViewTitle ,textViewDescription , textViewRoomNumber , textViewClassCode;
    EditText editTextTitle , editTextDescription , editTextRoomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_setting);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_save_class_setting){
            //Saving Changes
        }
        return super.onOptionsItemSelected(item);
    }
}
