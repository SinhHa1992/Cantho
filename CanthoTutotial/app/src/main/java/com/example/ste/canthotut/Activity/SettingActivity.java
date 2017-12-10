package com.example.ste.canthotut.Activity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ste.canthotut.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class SettingActivity extends AppCompatActivity {

    static final String USERNAME = "USERNAME";
    static final String PASSWORD = "PASSWORD";
    static final String PATH_REF = "USER";
    static final String PATH_DIR = Environment.getExternalStorageDirectory().getPath();
    static final String PATH_DIR_AUDIO = "/Zing MP3/";
    static final String PATH_DIR_IMAGE = "/Camera/";
    static final String PATH_DIR_FILE = "/CanThoTut/";
    static final String FILE_NAME = "user.txt";
    static final String TYPE_JPG = ".jpg";
    static final String TYPE_MP3 = ".mp3";
    static final String REF_LANGUAGE = "LANG";
    static final String LANGUAGE_VIETNAM = "vi";
    static final String LANGUAGE_ENGLISH = "en";

    private TextView mTvUsername;
    private TextView mTvPassword;
    private TextView mTvCountAudio;
    private TextView mTvCountImage;
    private SharedPreferences mSharedPreferences;
    private Locale mLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        init();
        chooseLanguage();
        //addShare();
        readShared();
        countAudio();
        countImage();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_choose_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_vietnam:
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString(REF_LANGUAGE, LANGUAGE_VIETNAM).apply();
                setLangRecreate(LANGUAGE_VIETNAM);
                break;
            case R.id.mn_english:
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString(REF_LANGUAGE, LANGUAGE_ENGLISH).apply();
                setLangRecreate(LANGUAGE_ENGLISH);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        mTvUsername = (TextView) findViewById(R.id.tv_username);
        mTvPassword = (TextView) findViewById(R.id.tv_password);
        mTvCountAudio = (TextView) findViewById(R.id.tv_count_audio);
        mTvCountImage = (TextView) findViewById(R.id.tv_count_image);

        mSharedPreferences = getSharedPreferences(PATH_REF, MODE_PRIVATE);
    }

    // Function choose language when choose menu
    public void setLangRecreate(String lang) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        mLocale = new Locale(lang);
        Locale.setDefault(mLocale);
        config.locale = mLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    // Function choose language when create activity
    private void chooseLanguage(){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = settings.getString(REF_LANGUAGE, "");
        if (! "".equals(lang) && ! config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    //Function test Shared Preferences
    private void addShare() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(USERNAME, "Nguoi dung thu");
        editor.putString(PASSWORD, "ABCDEFGH");
        editor.apply();
    }

    //Read from Shared Preferences after user login
    private void readShared() {
        String username = mSharedPreferences.getString(USERNAME, null);
        String password = mSharedPreferences.getString(PASSWORD, null);
        mTvUsername.setText(username);
        mTvPassword.setText(password);

        File file = new File(PATH_DIR + PATH_DIR_FILE, FILE_NAME);
        StringBuilder result = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
                result.append('\n');
            }
            br.close();
        } catch (IOException e) {

        }
    }

    //Count audio file from directory
    private void countAudio() {
        File file = new File(PATH_DIR + PATH_DIR_AUDIO);
        File[] list = file.listFiles();
        int count = 0;
        String name;
        if (list != null) {
            for (File f : list) {
                name = f.getName();
                if (name.endsWith(TYPE_MP3)) {
                    count++;
                }
            }
        }
        String labelAudio = getResources().getString(R.string.label_audio);
        mTvCountAudio.setText(labelAudio + " " + count);
    }

    //Count image file from directory
    private void countImage() {
        File file = new File(PATH_DIR + PATH_DIR_IMAGE);
        File[] list = file.listFiles();
        int count = 0;
        String name;
        if (list != null) {
            for (File f : list) {
                name = f.getName();
                if (name.endsWith(TYPE_JPG)) {
                    count++;
                }
            }
        }
        String labelImage = getResources().getString(R.string.label_image);
        mTvCountImage.setText(labelImage + " " + count);
    }
}
