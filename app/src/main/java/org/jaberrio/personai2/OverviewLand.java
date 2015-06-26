//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.


package org.jaberrio.personai2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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

        final ImageButton ament0 = (ImageButton) viewRoot.findViewById(R.id.ament0);
        final ImageButton ament1 = (ImageButton) viewRoot.findViewById(R.id.ament1);
        final ImageButton ament2 = (ImageButton) viewRoot.findViewById(R.id.ament2);
        final ImageButton ament3 = (ImageButton) viewRoot.findViewById(R.id.ament3);
        final ImageButton ament4 = (ImageButton) viewRoot.findViewById(R.id.ament4);
        final ImageButton ament5 = (ImageButton) viewRoot.findViewById(R.id.ament5);
        final ImageButton ament6 = (ImageButton) viewRoot.findViewById(R.id.ament6);
        final ImageButton ament7 = (ImageButton) viewRoot.findViewById(R.id.ament7);
        ament0.setOnClickListener(this);
        ament1.setOnClickListener(this);
        ament2.setOnClickListener(this);
        ament3.setOnClickListener(this);
        ament4.setOnClickListener(this);
        ament5.setOnClickListener(this);
        ament6.setOnClickListener(this);
        ament7.setOnClickListener(this);

        final TableLayout tableLayout = (TableLayout) viewRoot.findViewById(R.id.books);
        final FrameLayout frameLayout = (FrameLayout) viewRoot.findViewById(R.id.frameLayout2);
        CalendarView cV = (CalendarView) viewRoot.findViewById(R.id.calendarViewItem);
        final TextView date = (TextView) viewRoot.findViewById(R.id.date);
        final RelativeLayout relativeLayout = (RelativeLayout) viewRoot.findViewById(R.id.calandarView);

        //relativeLayout.setBackgroundColor(Color.rgb(149, 57, 0));


        final Context context = getActivity().getApplicationContext();

        frameLayout.setBackgroundColor(Color.alpha(0));
        tableLayout.setBackgroundColor(Color.alpha(0));
        cV.setBackgroundColor(Color.alpha(0));
        cV.setSelectedWeekBackgroundColor(Color.argb(110, 95, 95, 95));

        RefreshViews refreshViews = new RefreshViews();
        refreshViews.color(viewRoot);

        Calendar calendar = Calendar.getInstance();
        String rightnow = (String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "_" +  String.valueOf(calendar.get(Calendar.MONTH))  + "_" + String.valueOf(calendar.get(Calendar.YEAR)) + ".dat");

        refreshViews.listDisplayRefresh(viewRoot, context, rightnow);

        //ament0.setBackgroundColor(Color.rgb(102, 0, 204));
        //ament1.setBackgroundColor(Color.rgb(255, 102, 255));
        //ament3.setBackgroundColor(Color.rgb(102, 0, 204));
        //ament2.setBackgroundColor(Color.rgb(255, 102, 255));
        //ament4.setBackgroundColor(Color.rgb(102, 0, 204));
        //ament6.setBackgroundColor(Color.rgb(255, 102, 255));
        //ament7.setBackgroundColor(Color.rgb(102, 0, 204));
        //ament5.setBackgroundColor(Color.rgb(255, 102, 255));

        cV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                date.setText(String.valueOf(year) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth));

                currentDateSelected = String.valueOf(year) + "_" + String.valueOf(month) + "_" + String.valueOf(dayOfMonth) + ".dat";

                RefreshViews refreshViews = new RefreshViews();
                refreshViews.listDisplayRefresh(viewRoot, context, currentDateSelected);
            }
        });
        return viewRoot;
    }

    @Override
    public void onClick(View v) {

        //Periods are temperately hard coded

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fmtrans = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.ament0:

                MathClassAddEvent mathClassAddEvent = new MathClassAddEvent();
                fmtrans.replace(android.R.id.content, mathClassAddEvent);
                fmtrans.commit();

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

                RefreshViews refreshViews = new RefreshViews();
                refreshViews.listDisplayRefresh(viewRoot, context, currentDateSelected);

                break;
        }


    }

}
