package org.jaberrio.personai2;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

public class OverviewLand extends Fragment implements View.OnClickListener {

    String currentDateSelected;
    View viewRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_overview_land, container, false);

        final Button ament0 = (Button)viewRoot.findViewById(R.id.ament0);final Button ament1 = (Button)viewRoot.findViewById(R.id.ament1);final Button ament2 = (Button)viewRoot.findViewById(R.id.ament2);final Button ament3 = (Button)viewRoot.findViewById(R.id.ament3);final Button ament4 = (Button)viewRoot.findViewById(R.id.ament4);final Button ament5 = (Button)viewRoot.findViewById(R.id.ament5);final Button ament6 = (Button)viewRoot.findViewById(R.id.ament6);final Button ament7 = (Button)viewRoot.findViewById(R.id.ament7);
        ament0.setOnClickListener(this);ament1.setOnClickListener(this);ament2.setOnClickListener(this);ament3.setOnClickListener(this);ament4.setOnClickListener(this);ament5.setOnClickListener(this);ament6.setOnClickListener(this);ament7.setOnClickListener(this);

        CalendarView cV = (CalendarView)viewRoot.findViewById(R.id.calendarViewItem);
        final TextView date = (TextView)viewRoot.findViewById(R.id.date);

        final Context context = getActivity().getApplicationContext();



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

            date.setText(String.valueOf(year) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth));

                currentDateSelected = String.valueOf(year) + "_" + String.valueOf(month) + "_" + String.valueOf(dayOfMonth) + ".dat";

                RefreshListView refreshListView = new RefreshListView();
                refreshListView.listDisplayRefresh(viewRoot, context, currentDateSelected);
            }
        });
        return viewRoot;
    }

    @Override
    public void onClick(View v) {

        //Periods are temperately hard coded

        switch (v.getId()){
            case R.id.ament0:

                break;

            case R.id.ament1:

                break;

            case R.id.ament2:

                break;

            case R.id.ament3:

                break;

            case R.id.ament4:

                break;

            case R.id.ament5:

                break;

            case R.id.ament6:

                break;

            case R.id.ament7:

                Calendar rightNow = Calendar.getInstance();

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
                db.writeData(context, data,
                        //FILE NAME
                        String.valueOf(currentDateSelected));

                Toast finishedLoad = Toast.makeText(context, "Done Writing Information", Toast.LENGTH_SHORT);
                finishedLoad.show();

                RefreshListView refreshListView = new RefreshListView();
                refreshListView.listDisplayRefresh(viewRoot, context, currentDateSelected);

                break;
        }


    }
}
