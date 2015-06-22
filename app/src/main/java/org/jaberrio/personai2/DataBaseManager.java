package org.jaberrio.personai2;




import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataBaseManager {


    public void writeData (Context context,String[] data) {
        try {
            FileOutputStream fOut = context.openFileOutput("data.dat", Context.MODE_PRIVATE) ;
            OutputStreamWriter osw = new OutputStreamWriter ( fOut ) ;

            for (int i = 0; i < data.length; i++){
                osw.append(data[i]);
                osw.append('\n');
            }

            osw.flush () ;
            osw.close () ;
        } catch ( Exception e ) {
            e.printStackTrace ( ) ;
        }


    }

    public String readSavedData (Context context) {
        StringBuilder datax = new StringBuilder("");
        try {
            FileInputStream fInStream = context.openFileInput("data.dat") ;
            InputStreamReader isr = new InputStreamReader ( fInStream ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;

            String readString = buffreader.readLine ( ) ;
            while ( readString != null ) {
                datax.append("\n");
                datax.append(readString);
                readString = buffreader.readLine ( ) ;
            }

            isr.close ( ) ;
        } catch ( IOException ioe ) {
            ioe.printStackTrace ( ) ;
        }
        return datax.toString() ;
    }
}

