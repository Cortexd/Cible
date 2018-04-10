package com.example.renaud.cible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SaisieActivity extends AppCompatActivity {

    // Liste des tirs
    List<CinqTir> listeDesTirs;

    ListView mListView;

    CinqTirAdapter adapter;

    // Tir en cours
    CinqTir cinqTirsActuel;


    static EditText etDate;
    static EditText etTime;



    // Creation vue
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        // Permet d'eviter l'affichage direct de saisie sur le Edittex de date
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        // Creation tir1
        cinqTirsActuel = new CinqTir(1);
        listeDesTirs = new ArrayList<>();

        // Liaison listView adapter
        mListView = (ListView) findViewById(R.id.listView);
        adapter = new CinqTirAdapter(SaisieActivity.this, listeDesTirs);
        mListView.setAdapter(adapter);

        // recup edir
        etDate = (EditText) findViewById(R.id.editTextDate);
        etTime = (EditText) findViewById(R.id.editTextTime);
        displayDateAndTime();

    }


    public void actionEditDate(View v) {
        // showDialog(DATE_DIALOG_ID);
//        DialogFragment newFragment = new DatePickerFragment();
//        newFragment.show(getFragmentManager(),"datePicker");
    }


    // appui sur un boutton de score
    public void ScoreClicked(int score)
    {
        cinqTirsActuel.AjoutResultat(score);
        RefrechActuel();
    }


    // Annule la derniere valeur saisie de score
    public void handleClickButtonCancelLast(View v)
    {
        cinqTirsActuel.EnleveLeDernierResultat();
        RefrechActuel();
    }

    // Sauvegarde la liste des 5 scores dans le listView
    public void handleClickButtonOk(View v)
    {
        listeDesTirs.add(cinqTirsActuel);

        int compteur = listeDesTirs.size()+1;
        cinqTirsActuel = new CinqTir(compteur);
        adapter.notifyDataSetChanged();
        RefrechActuel();
    }


    // Refresh le text view
    public void RefrechActuel()
    {
        TextView tv = (TextView) findViewById(R.id.textViewSaisie);
        tv.setText(cinqTirsActuel.GetResultatLigne());
    }

    // Affichage date
    private void displayDateAndTime()
    {
        Calendar cal = Calendar.getInstance();
        etDate.setText(String.format("%02d/%02d/%04d", cal.get(Calendar.DAY_OF_MONTH) , cal.get(Calendar.MONTH) ,cal.get(Calendar.YEAR)));
        etTime.setText(String.format("%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE)));
    }



    public void handleClickButton0(View v) {        this.ScoreClicked(0);    }
    public void handleClickButton1(View v) {        this.ScoreClicked(1);    }
    public void handleClickButton2(View v) {        this.ScoreClicked(2);    }
    public void handleClickButton3(View v) {        this.ScoreClicked(3);    }
    public void handleClickButton4(View v) {        this.ScoreClicked(4);    }
    public void handleClickButton5(View v) {        this.ScoreClicked(5);    }
    public void handleClickButton6(View v) {        this.ScoreClicked(6);    }
    public void handleClickButton7(View v) {        this.ScoreClicked(7);    }
    public void handleClickButton8(View v) {        this.ScoreClicked(8);    }
    public void handleClickButton9(View v) {        this.ScoreClicked(9);    }
    public void handleClickButton10(View v) {       this.ScoreClicked(10);   }

    // Sauvegarde la session en base
    public void handleClickButtonSaveSession(View v)
    {


    }


}
