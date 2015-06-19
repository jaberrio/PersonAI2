package org.jaberrio.personai2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main); Hello
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fmtrans = fm.beginTransaction();

        Toast configUpdates = Toast.makeText(getApplicationContext(), "Configuation Update", Toast.LENGTH_SHORT);
        configUpdates.show();

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){

            OverviewLand overviewLand = new OverviewLand();
            fmtrans.replace(android.R.id.content,overviewLand);

        }else{

            OverviewPort overviewport = new OverviewPort();
            fmtrans.replace(android.R.id.content,overviewport);
        }

        // Schedule for the replacement of the Fragment as soon as possible
        fmtrans.commit();

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
