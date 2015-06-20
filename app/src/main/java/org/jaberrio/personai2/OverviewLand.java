package org.jaberrio.personai2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class OverviewLand extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_overview_land, container, false);

        final Button ament0 = (Button)view.findViewById(R.id.ament0);
        final Button ament1 = (Button)view.findViewById(R.id.ament1);
        final Button ament2 = (Button)view.findViewById(R.id.ament2);
        final Button ament3 = (Button)view.findViewById(R.id.ament3);
        final Button ament4 = (Button)view.findViewById(R.id.ament4);
        final Button ament5 = (Button)view.findViewById(R.id.ament5);
        final Button ament6 = (Button)view.findViewById(R.id.ament6);
        final Button ament7 = (Button)view.findViewById(R.id.ament7);

        Context context = getActivity().getApplicationContext();

        ListView mainListView ;
        ArrayAdapter<String> listAdapter ;

        CalendarView cV = (CalendarView)view.findViewById(R.id.calendarViewItem);
        final TextView date = (TextView)view.findViewById(R.id.date);

        ament0.setOnClickListener(this);
        ament1.setOnClickListener(this);
        ament2.setOnClickListener(this);
        ament3.setOnClickListener(this);
        ament4.setOnClickListener(this);
        ament5.setOnClickListener(this);
        ament6.setOnClickListener(this);
        ament7.setOnClickListener(this);

        ament0.setBackgroundColor(Color.rgb(102, 0, 204));
        ament1.setBackgroundColor(Color.rgb(255, 102, 255));
        ament3.setBackgroundColor(Color.rgb(102, 0, 204));
        ament2.setBackgroundColor(Color.rgb(255, 102, 255));
        ament4.setBackgroundColor(Color.rgb(102, 0, 204));
        ament7.setBackgroundColor(Color.rgb(255, 102, 255));
        ament5.setBackgroundColor(Color.rgb(102, 0, 204));
        ament6.setBackgroundColor(Color.rgb(255, 102, 255));

        cV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date.setText(String.valueOf(year) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth));
            }
        });

        mainListView = (ListView)view.findViewById(R.id.listTo);

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(context, R.layout.list_today, planetList);

        // Add more planets.
        listAdapter.add( "This is a really long text field to prove the concept of of multi line things" );
        listAdapter.add( "Pluto" );
        listAdapter.add("Haumea" );
        listAdapter.add("Makemake" );
        listAdapter.add( "Eris" );


        mainListView.setBackgroundColor(Color.rgb(255,102,255));

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);


        return view;
    }


    @Override
    public void onClick(View v) {

        Context context = getActivity().getApplicationContext();

        DataBaseManager db = new DataBaseManager();
        db.writeData(context,"Obama");


    }
}
