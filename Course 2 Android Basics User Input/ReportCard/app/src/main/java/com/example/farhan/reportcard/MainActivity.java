package com.example.farhan.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.mText);

        //Creating ReportCard Class Object and passing data in its Constructor.
        ReportCard reportCard = new ReportCard("Farhan", 'A', 9, 80, 60, 90, 70, 80);

        //Calling this method to Sum all marks which we pass in our Constructor.
        reportCard.getTotalMarks();

        //Calling toString method to show our Text form of Class.
        textView.setText(reportCard.toString());
    }
}
