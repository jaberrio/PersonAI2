//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.

package org.jaberrio.personai2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it


        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void onDateSet(DatePicker view, int year, int month, int day) {


        DataBaseManager dataBaseManager = new DataBaseManager();
        String date = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
        dataBaseManager.tempSaveCurrentEvent(DataBaseManager.FieldTypes.DUE_DATE, date, getActivity().getApplicationContext());

    }
}