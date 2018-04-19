package com.example.renaud.cible;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startSaisieActivity();
            }
        });

        GenerateGraphics();

    }

    private void GenerateGraphics()
    {
        barChart = (BarChart) findViewById(R.id.bargraph);


        Integer[] valeursTotal = {  500,  400,  300,  500,  470};
        Float[]   valeursMoyenne = { 10f, 5.4f, 6.6f, 7.2f, 8.5f};
        String[]  valeursDates = {"01/01/2018",
                "02/01/2018",
                "03/01/2018",
                "04/01/2018",
                "05/01/2018"               };

        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();

        // fill the lists
        for(int i = 0; i < valeursTotal.length; i++) {
            entriesGroup1.add(new BarEntry(i, valeursTotal[i]));
            entriesGroup2.add(new BarEntry(i, valeursMoyenne[i]));
        }

        BarDataSet set1 = new BarDataSet(entriesGroup1, "Total");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setStackLabels(valeursDates);

        BarDataSet set2 = new BarDataSet(entriesGroup2, "Moyenne");
        set2.setAxisDependency(YAxis.AxisDependency.RIGHT);

        set1.setColor(R.color.colorPrimary);
        set2.setColor(Color.GREEN);

        float groupSpace = 0.06f;
        float barSpace = 0.02f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
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

        barChart.getXAxis().setValueFormatter(new LabelFormatter(valeursDates));

        barChart.invalidate(); // refresh

    }


    public void startSaisieActivity()
    {
        Intent intent = new Intent(this, SaisieActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        // Passage parametre a l'activite
        // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
