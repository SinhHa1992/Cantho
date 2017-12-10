package com.example.ste.canthotut.Download;

import android.os.AsyncTask;
import android.util.Log;

import com.example.ste.canthotut.Constant.Constant;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by admin on 12/10/2017.
 */

public class DownloadFile extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        int count;
        try {
            URL url = new URL(params[0]);
            URLConnection conection = url.openConnection();
            conection.connect();

            int lenghtOfFile = conection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(),
                                    8192);

            OutputStream output = new FileOutputStream(Constant.DIRECTORY_PICTURE_PATH +
                                    params[1]);

            byte data[] = new byte[1024];
            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();

        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }
        return null;
    }
}