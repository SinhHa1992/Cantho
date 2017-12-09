package com.example.ste.canthotut.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ste.canthotut.R;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PlayMusicActivity";

    private TextView mSongName;
    private Button mBtnPlay;
    private Button mBtnStop;
    private Button mBtnNext;
    private Button mBtnPrevious;
    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initWidget();
    }

    private void initWidget() {
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSongName = (TextView) findViewById(R.id.tvSongName);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mBtnStop = (Button) findViewById(R.id.btnStop);
        mBtnPrevious = (Button) findViewById(R.id.btnPrevious);
        mBtnPlay = (Button) findViewById(R.id.btnPlay);

        mBtnPlay.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        mBtnPrevious.setOnClickListener(this);
        mBtnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                playMedia();
                break;
            case R.id.btnStop:
                stopMedia();
                break;
            case R.id.btnNext:
                playNextMedia();
                break;
            case R.id.btnPrevious:
                playPrevious();
                break;
        }
    }

    private void playMedia() {

    }

    private void playPrevious() {

    }

    private void playNextMedia() {

    }

    private void stopMedia() {

    }
}
