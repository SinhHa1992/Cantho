package apptk.com.fileexplorer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String rootPath = Environment.getExternalStorageDirectory().toString();

        File file = new File(rootPath);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++){
            Log.e("logg", files[i]);
        }
    }
}
