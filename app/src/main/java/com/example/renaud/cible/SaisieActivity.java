package com.example.renaud.cible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class SaisieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        displayDate();
    }

    private void displayDate() {

        Date aujourdhui = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(shortDateFormat.format(aujourdhui));
    }
}
