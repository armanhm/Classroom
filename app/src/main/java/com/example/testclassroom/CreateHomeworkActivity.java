package com.example.testclassroom;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class CreateHomeworkActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    TextView textViewDate;
    Button buttonCreate;
    int year, month, day;
    int hour, minute;
    int finalHour , finalMinute;
    int finalYear , finalMonth , finalDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_homework);

        textViewDate = findViewById(R.id.textViewTimePicker);
        buttonCreate = findViewById(R.id.buttonCreateHomework);
        textViewDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(CreateHomeworkActivity.this, CreateHomeworkActivity.this,year,month,day);
            datePickerDialog.show();
            buttonCreate.setOnClickListener(v1 -> {
                TransferMessage transferMessage = new TransferMessage();
                transferMessage.execute();
            });
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        finalYear = year;
        finalMonth = month;
        finalDay = dayOfMonth;
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(CreateHomeworkActivity.this,CreateHomeworkActivity.this,hour,minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        finalHour = hourOfDay;
        finalMinute = minute;
        Toast.makeText(CreateHomeworkActivity.this,year + "/" + month + "/" + day  + "     " + hour + ":" + minute,Toast.LENGTH_SHORT);
        Log.e("Date",finalYear + "");
        Log.e("Date",finalMonth + "");
        Log.e("Date",finalDay + "");
        Log.e("Date",finalHour + "");
        Log.e("Date",finalMinute + "");
    }
}
