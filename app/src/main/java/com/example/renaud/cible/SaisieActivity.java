package com.example.renaud.cible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class SaisieActivity extends AppCompatActivity {

    List<CinqTir> listeDesTirs;

    CinqTir cinqTirsActuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        displayDate();

        cinqTirsActuel = new CinqTir();



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
        cinqTirsActuel.AjoutResultat(0);
        tv.setText(cinqTirsActuel.GetResultatLigne());
    }

    public void handleClickButtonCancelLast(View v)
    {
        TextView tv = (TextView) findViewById(R.id.textViewSaisie);
        cinqTirsActuel.EnleveLeDernierResultat();
        tv.setText(cinqTirsActuel.GetResultatLigne());
    }

    public void handleClickButtonOk(View v)
    {
        TextView tv = (TextView) findViewById(R.id.textViewSaisie);
        tv.setText(cinqTirsActuel.GetResultatLigne());
    }

}
