//This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
//        To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.

package org.jaberrio.personai2;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); Hello comment

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            // Stop here, cause otherwise app will crash and No time for fix
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;

        }

        handleIntent(getIntent());

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        FragmentManager fm = getFragmentManager();

        FragmentTransaction fmtrans = fm.beginTransaction();

        Toast configUpdates = Toast.makeText(getApplicationContext(), "Configuation Update", Toast.LENGTH_SHORT);
        configUpdates.show();

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            setTitle("PersonAI");
            OverviewLand overviewLand = new OverviewLand();
            fmtrans.replace(android.R.id.content, overviewLand);

        } else {
            OverviewPort overviewport = new OverviewPort();
            fmtrans.replace(android.R.id.content, overviewport);
            setTitle("PersonAI");
        }

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
        if (id == R.id.action_prosssesing) {

            Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("processing.test.sketch_150625a");
            startActivity(LaunchIntent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");

        RefreshViews refreshViews = new RefreshViews();
        refreshViews.infoRefresh(v.getRootView(), getApplicationContext());

    }

    public void refresh(View v) {
        RefreshViews refreshViews = new RefreshViews();
        refreshViews.infoRefresh(v.getRootView(), getApplicationContext());
    }

    public void save(View v) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fmtrans = fm.beginTransaction();

        OverviewLand overviewLand = new OverviewLand();
        fmtrans.replace(android.R.id.content, overviewLand);

        fmtrans.commit();


    }


    private void handleIntent(Intent intent) {

        String msg = null;

        try {

            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            Ndef ndef = Ndef.get(tag);

            NdefMessage ndefMessage = ndef.getCachedNdefMessage();

            NdefRecord[] records = ndefMessage.getRecords();
            for (NdefRecord ndefRecord : records) {
                if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                    try {
                        byte[] payload = ndefRecord.getPayload();
                        String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";

                        int languageCodeLength = payload[0] & 0063;

                        msg = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);

                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }

            FragmentManager fm = getFragmentManager();
            FragmentTransaction fmtrans = fm.beginTransaction();

            switch (msg) {
                case "math":
                    AddTextBookField addTextBookField = new AddTextBookField();
                    fmtrans.replace(android.R.id.content, addTextBookField);
                    fmtrans.commit();
                    break;
                case "lang_arts":

                    break;
            }
            Toast finishedLoad = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
            finishedLoad.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}