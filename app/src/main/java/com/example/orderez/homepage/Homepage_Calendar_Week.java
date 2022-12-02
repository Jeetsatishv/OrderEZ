package com.example.orderez.homepage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.orderez.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Homepage_Calendar_Week extends AppCompatActivity {

    TextView monthYearText; //Year and Month Textview
    LocalDate selectedDate;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_week);

        //Default set
        monthYearText = findViewById(R.id.monthYearText);
        ImageButton preBtn = findViewById(R.id.pre_btn);
        ImageButton nextBtn = findViewById(R.id.next_btn);

        //Show present time
        selectedDate = LocalDate.now();

        //Set screen

        //Click Events (Arrow buttons)
        preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDate = selectedDate.minusMonths(1); //When it's clicked it goes to previous month
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDate = selectedDate.plusMonths(1);
            }
        });

    }//onCreate

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String monthYearFormat(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM yyyy");

        return date.format(formatter);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void setMonthView(){
        monthYearText.setText(monthYearFormat(selectedDate));
    }
}