package com.example.ste.canthotut;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class SettingActivity extends AppCompatActivity {

    static final String USERNAME = "USER_NAME";
    static final String PASSWORD = "PASSWORD";
    static final String PATH_REF = "USER";
    static final String PATH_DIR = Environment.getExternalStorageDirectory().getPath()+"/CanThoTut/";
    static final String PATH_DIR_AUDIO = Environment.getExternalStorageDirectory().getPath()+"/Zing MP3/";
    static final String PATH_DIR_IMAGE = Environment.getExternalStorageDirectory().getPath()+"/Camera/";
    static final String FILE_NAME = "USER.txt";

    TextView tvUsername,tvPassword, tvCountAudio, tvCountImage;
    ImageView imgAvatar;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        init();
        //addShare();
        readShared();
        countAudio();
        countImage();

    }

    private void init(){
        imgAvatar = (ImageView) findViewById(R.id.img_avatar);
        tvUsername = (TextView) findViewById(R.id.tv_username);
        tvPassword = (TextView) findViewById(R.id.tv_password);
        tvCountAudio = (TextView) findViewById(R.id.tv_count_audio);
        tvCountImage = (TextView) findViewById(R.id.tv_count_image);

        sharedPreferences = getSharedPreferences(PATH_REF, MODE_PRIVATE);

    }

    //Function test Shared Preferences
    private void addShare(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, "Nguoi dung thu");
        editor.putString(PASSWORD, "ABCDEFGH");
        editor.apply();
    }

    //Read from Shared Preferences after user login
    private void readShared(){
        String username = sharedPreferences.getString(USERNAME, null);
        String password = sharedPreferences.getString(PASSWORD, null);
        tvUsername.setText(username);
        tvPassword.setText(password);

        /*File file = new File(PATH_DIR,FILE_NAME);

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {

        }
        Log.e("ABCD", text.toString());*/
    }

    //Count audio file from directory
    private void countAudio(){
        File file=new File(PATH_DIR_AUDIO);
        File[] list = file.listFiles();
        int count = 0;
        for (File f: list){
            String name = f.getName();
            if (name.endsWith(".mp3")) {
                count++;
            }
        }
        tvCountAudio.setText("File AUDIO: " + count);
    }

    //Count image file from directory
    private void countImage(){
        File file=new File(PATH_DIR_IMAGE);
        File[] list = file.listFiles();
        int count = 0;
        for (File f: list){
            String name = f.getName();
            if (name.endsWith(".jpg")) {
                count++;
            }
        }
        tvCountImage.setText("File Picture: " + count);
    }
}
