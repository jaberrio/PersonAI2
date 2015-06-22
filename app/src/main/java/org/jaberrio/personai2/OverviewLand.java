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
import android.widget.Toast;
import java.util.Calendar;

import java.util.ArrayList;
import java.util.Arrays;

public class OverviewLand extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View viewRoot = inflater.inflate(R.layout.fragment_overview_land, container, false);

        final Button ament0 = (Button)viewRoot.findViewById(R.id.ament0);
        final Button ament1 = (Button)viewRoot.findViewById(R.id.ament1);
        final Button ament2 = (Button)viewRoot.findViewById(R.id.ament2);
        final Button ament3 = (Button)viewRoot.findViewById(R.id.ament3);
        final Button ament4 = (Button)viewRoot.findViewById(R.id.ament4);
        final Button ament5 = (Button)viewRoot.findViewById(R.id.ament5);
        final Button ament6 = (Button)viewRoot.findViewById(R.id.ament6);
        final Button ament7 = (Button)viewRoot.findViewById(R.id.ament7);

        CalendarView cV = (CalendarView)viewRoot.findViewById(R.id.calendarViewItem);
        final TextView date = (TextView)viewRoot.findViewById(R.id.date);

        final Context context = getActivity().getApplicationContext();

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
        ament6.setBackgroundColor(Color.rgb(255, 102, 255));
        ament7.setBackgroundColor(Color.rgb(102, 0, 204));
        ament5.setBackgroundColor(Color.rgb(255, 102, 255));

        cV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
            Calendar rightNow = Calendar.getInstance();
            date.setText(String.valueOf(year) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth)
                + "\n" + rightNow.get(Calendar.YEAR) + "/"
                + rightNow.get(Calendar.MONTH) + "/"
                + rightNow.get(Calendar.DAY_OF_MONTH));

                Refresh refresh = new Refresh();
                refresh.listDisplayRrefesh(viewRoot, context);
            }
        });

        return viewRoot;
    }

    @Override
    public void onClick(View v) {

        String[] data = new String[7];

        data[0] = String.valueOf(System.currentTimeMillis());
        data[1] = "Math Project Textbook";
        data[2] = String.valueOf(System.currentTimeMillis() + 432000);
        data[3] = "Math";
        data[4] = "7th";
        data[5] = "This is my first assigment";
        data[6] = null;

        Context context = getActivity().getApplicationContext();

        DataBaseManager db = new DataBaseManager();
        db.writeData(context, data, "data.dat");

        Toast finishedLoad = Toast.makeText(context, "Done Writing Information", Toast.LENGTH_SHORT);
        finishedLoad.show();



    }
}
