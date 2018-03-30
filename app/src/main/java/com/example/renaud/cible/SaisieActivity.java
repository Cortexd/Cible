package com.example.renaud.cible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class SaisieActivity extends AppCompatActivity {

    List<cinqTir> listeDesTirs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        displayDate();

        listeDesTirs.add(new cinqTir());
    }

    private void displayDate() {

        Date aujourdhui = new Date();

        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);

        TextView tv = (TextView) findViewById(R.id.textViewDate);
        tv.setText(shortDateFormat.format(aujourdhui));
    }


    public void handleClickButton0(View v) {
        TextView tv = (TextView) findViewById(R.id.textViewSaisie);
        tv.append(" 0");
    }

    public void handleClickButtonCancelLast(View v) {

    }
    public void handleClickButtonOk(View v) {

    }

}
