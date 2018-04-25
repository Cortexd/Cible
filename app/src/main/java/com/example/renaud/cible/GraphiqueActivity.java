package com.example.renaud.cible;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.renaud.cible.Base.Session;
import com.example.renaud.cible.Base.SessionDataSource;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class GraphiqueActivity extends AppCompatActivity {


    BarChart barChart;
    SessionDataSource sessionDataSource;
    List<Integer> valeursTotal = new ArrayList<>();
    List<Float>   valeursMoyenne = new ArrayList<>();
    List<String>  valeursDates = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphique);

        // Base de donnes
        sessionDataSource = new SessionDataSource(this);
        sessionDataSource.open();

        GetDataFromBase();

        GenerateGraphics();
    }

    private void GetDataFromBase() {

//        valeursTotal.add(500);
//        valeursTotal.add(500);
//        valeursTotal.add(500);
//        valeursTotal.add(500);
//        valeursTotal.add(500);
//        valeursTotal.add(500);
//
//
//
//        valeursMoyenne.add(5.4f);
//        valeursMoyenne.add(5.4f);
//        valeursMoyenne.add(5.4f);
//        valeursMoyenne.add(5.4f);
//        valeursMoyenne.add(5.4f);
//        valeursMoyenne.add(5.4f);
//
//
//        valeursDates.add("01/01/2018");
//        valeursDates.add("01/01/2018");
//        valeursDates.add("01/01/2018");
//        valeursDates.add("01/01/2018");
//        valeursDates.add("01/01/2018");
//        valeursDates.add("01/01/2018");


        List<Session> allSessions = sessionDataSource.getAllSessions();

        for (Session session : allSessions) {

            valeursTotal.add(session.getSession_somme());
            valeursMoyenne.add(session.getSession_moyenne());
            valeursDates.add(session.getSession_date());
        }



    }


    private void GenerateGraphics()
    {

        barChart = findViewById(R.id.bargraph);

        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();

        // fill the lists
        for(int i = 0; i < valeursTotal.size(); i++) {
            entriesGroup1.add(new BarEntry(i, valeursTotal.get(i)));
            entriesGroup2.add(new BarEntry(i, valeursMoyenne.get(i)));
        }

        BarDataSet set1 = new BarDataSet(entriesGroup1, "Total");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        String[] arrayDate = new String[valeursDates.size()];
        valeursDates.toArray(arrayDate);
        
        set1.setStackLabels(arrayDate);

        BarDataSet set2 = new BarDataSet(entriesGroup2, "Moyenne");
        set2.setAxisDependency(YAxis.AxisDependency.RIGHT);

        set1.setColor(R.color.colorPrimary);
        set2.setColor(Color.GREEN);

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.35f; // x2 dataset
        // (0.02 + 0.45) * 2 + 0.06 = 1.00 -> interval per "group"

        BarData data = new BarData(set1, set2);
        data.setBarWidth(barWidth); // set the width of each bar
        barChart.setData(data);
        barChart.groupBars(-1f, groupSpace, barSpace); // perform the "explicit" grouping
        XAxis xAxis = barChart.getXAxis();
        xAxis.setCenterAxisLabels(true);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);

        //     barChart.getXAxis().setValueFormatter(new LabelFormatter(arrayDate));

        barChart.invalidate(); // refresh

    }
}
