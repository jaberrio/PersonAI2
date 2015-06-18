package org.jaberrio.personai2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

public class OverviewLand extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_overview_land, container, false);

        CalendarView cV = (CalendarView)view.findViewById(R.id.calendarViewItem);
        final TextView date = (TextView)view.findViewById(R.id.date);

        cV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date.setText(String.valueOf(year) + ":" + String.valueOf(month) + ":" + String.valueOf(dayOfMonth));
            }
        });

        return view;
    }



}
