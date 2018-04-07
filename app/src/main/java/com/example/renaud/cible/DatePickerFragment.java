package com.example.renaud.cible;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public static class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public EditText editText;
    DatePicker dpResult;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        //return new DatePickerDialog(getActivity(), (EditSessionActivity)getActivity(), year, month, day);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        mDateDisplay .setText(String.valueOf(day) + "/"
                + String.valueOf(month + 1) + "/" + String.valueOf(year));
        // set selected date into datepicker also


    }
}
}