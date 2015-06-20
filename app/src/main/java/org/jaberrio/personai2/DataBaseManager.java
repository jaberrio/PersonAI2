package org.jaberrio.personai2;


import android.content.Context;

import java.io.FileOutputStream;

public class DataBaseManager {

    String filename = "myfile";
    String string = "Hello world!";
    FileOutputStream outputStream;

    public void setDataBase(Context context) {

        String filename = "CoolFile";
        String string = "Obama";

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
