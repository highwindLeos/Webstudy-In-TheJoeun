package com.tj.widget;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private Button btnStart, btnEnd;
    private RadioButton radioCalender, radioTime;
    private CalendarView calendarView;
    private TimePicker timePicker;
    private TextView textYear, textMonth, textDay, textHour, textMin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chrometer);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        radioCalender = (RadioButton)findViewById(R.id.radioCalender);
        radioTime = (RadioButton)findViewById(R.id.radioTime);
        calendarView = (CalendarView)findViewById(R.id.calenderView);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        textYear =(TextView)findViewById(R.id.textYear);
        textMonth =(TextView)findViewById(R.id.textMonth);
        textDay =(TextView)findViewById(R.id.textDay);
        textHour =(TextView)findViewById(R.id.textHour);
        textMin =(TextView)findViewById(R.id.textMin);

        calendarView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime()); // 초시계 초기화
                chronometer.start();
                chronometer.setTextColor(Color.RED);
                textYear.setTextColor(Color.GRAY);
                textMonth.setTextColor(Color.GRAY);
                textDay.setTextColor(Color.GRAY);
                textHour.setTextColor(Color.GRAY);
                textMin.setTextColor(Color.GRAY);

                textYear.setText("0000");
                textMonth.setText("00");
                textDay.setText("00");
                textHour.setText("00");
                textMin.setText("00");
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                textYear.setTextColor(Color.BLUE);
                textMonth.setTextColor(Color.BLUE);
                textDay.setTextColor(Color.BLUE);
                textHour.setTextColor(Color.BLUE);
                textMin.setTextColor(Color.BLUE);
            }
        });

        radioCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });

        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                textYear.setText(""+year);
                textMonth.setText(String.valueOf(month));
                textDay.setText(Integer.toString(dayOfMonth));
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textHour.setText(String.valueOf(hourOfDay));
                textMin.setText(String.valueOf(minute));
            }
        });
    }
}
