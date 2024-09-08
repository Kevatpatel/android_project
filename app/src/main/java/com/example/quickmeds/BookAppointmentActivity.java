package com.example.quickmeds;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
   EditText ed1,ed2,ed3,ed4;
   TextView tv;
   private DatePickerDialog datepickerdialog;
   private TimePickerDialog timepickerdialog;
   private Button datebutton,timebutton,btnbook,btnback;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv=findViewById(R.id.textViewapptitle);
        ed1=findViewById(R.id.textviewappfullname);
        ed2=findViewById(R.id.textviewappaddress);
        ed3=findViewById(R.id.textviewappcontact);
        ed4=findViewById(R.id.textviewappfees);
        datebutton=findViewById(R.id.buttonappdate);
        timebutton=findViewById(R.id.buttonapptime);
        btnbook=findViewById(R.id.btnappbook);
        btnback=findViewById(R.id.btnappbook);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it=getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons fees:"+fees+"/-");


        initDatepicker();
        datebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datepickerdialog.show();
            }
        });


        initTimepicker();
        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timepickerdialog.show();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctor.class));
            }
        });

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void initDatepicker()
    {
        DatePickerDialog.OnDateSetListener datesetlistener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                datebutton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datepickerdialog=new DatePickerDialog(this,style,datesetlistener,year,month,day);
        datepickerdialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private void initTimepicker()
    {
        TimePickerDialog.OnTimeSetListener timesetlistener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timebutton.setText(i+":"+i1);
            }


        };
        Calendar cal= Calendar.getInstance();

        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_DARK;
        timepickerdialog=new TimePickerDialog(this,style,timesetlistener,hrs,mins,true);

    }
}