package org.jaberrio.personai2;


        import android.content.Context;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class RefreshViews {


    public void listDisplayRefresh(View view, Context context, String date){

        DataBaseManager db = new DataBaseManager();

        ListView mainListView ;
        ArrayAdapter<String> listAdapter;

        mainListView = (ListView)view.findViewById(R.id.listEvents);

        ArrayList<String> planetList = new ArrayList<String>();

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(context, R.layout.list_today, planetList);

        // Add
        listAdapter.add( "This is a really long text field to prove the concept of of multi line things" );
        listAdapter.add( "Pluto" );
        listAdapter.add("Haumea" );
        listAdapter.add("Makemake" + "\n" + "Cool" );
        listAdapter.add(db.readSavedData(context,date));

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);
    }

    public void infoRefresh(View view,Context context){


        TextView dueDate = (TextView)view.getRootView().findViewById(R.id.dueDate);
        TextView periodText = (TextView)view.getRootView().findViewById(R.id.periodText);

        DataBaseManager dataBaseManager = new DataBaseManager();
        periodText.setText("Period: " + dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.PERIOD,context));
        dueDate.setText(dataBaseManager.tempGetCurrentEvent(DataBaseManager.FieldTypes.DUE_DATE,context));


    }
}


