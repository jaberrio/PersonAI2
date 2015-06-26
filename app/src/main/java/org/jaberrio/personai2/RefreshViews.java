//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.


package org.jaberrio.personai2;


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RefreshViews {

    ListView mainListView;
    ArrayAdapter<String> listAdapter;

    public void color(View view) {

        mainListView = (ListView) view.findViewById(R.id.listEvents);
        mainListView.setBackgroundColor(Color.alpha(0));
    }

    public void listDisplayRefresh(View view, Context context, String date) {

        DataBaseManager db = new DataBaseManager();

        mainListView = (ListView) view.findViewById(R.id.listEvents);

        ArrayList<String> planetList = new ArrayList<String>();

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(context, R.layout.list_today, planetList);

        // Add
        listAdapter.add("Period: 1" + "\n" +"Assignment: Textbook Work" + "\n" + "Assigned: June, 5, 2015");
        listAdapter.add("Period: 2" + "\n" +"Assignment: Write An Essay" + "\n" + "Assigned: June, 5, 2015");
        listAdapter.add("Period: 3" + "\n" +"Assignment: Read Romeo And Juliet" + "\n" + "Assigned: June, 5, 2015");
        listAdapter.add("Period: 4" + "\n" +"Assignment: Read About The Colombian Exchange" + "\n" + "Assigned: June, 5, 2015");
        listAdapter.add(db.readSavedData(context, date));

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);
    }

    public void infoRefresh(View view, Context context) {


        TextView dueDate = (TextView) view.getRootView().findViewById(R.id.dueDate);
        TextView periodText = (TextView) view.getRootView().findViewById(R.id.periodText);

        DataBaseManager dataBaseManager = new DataBaseManager();
        periodText.setText("Page Number: " + dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PAGE_NUMBER, context));
        dueDate.setText(dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.DUE_DATE, context));


    }
}


