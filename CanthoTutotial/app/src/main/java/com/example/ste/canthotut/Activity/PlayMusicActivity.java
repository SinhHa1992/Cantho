package com.example.ste.canthotut.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ste.canthotut.Constant.Constant;
import com.example.ste.canthotut.Model.MusicObject;
import com.example.ste.canthotut.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "PlayMusicActivity";

    private TextView mSongName;
    private Button mBtnPlay;
    private Button mBtnStop;
    private Button mBtnNext;
    private Button mBtnPrevious;
    private SeekBar mSeekBar;

    private MediaPlayer mPlayer;
    private List<MusicObject> mListMusicObject;
    private int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initWidget();
        playMedia();
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

    /**
     * auto play video
     */

    private void playMedia() {
        mPlayer = new MediaPlayer();
        mListMusicObject = new ArrayList<>();

        currentPosition = getIntent().getIntExtra(Constant.POSITION_SONG_EXTRA, 0);
        String pathSong = getIntent().getStringExtra(Constant.PATH_SONG_EXTRA);
        String nameSong = getIntent().getStringExtra(Constant.NAME_SONG_EXTRA);

        mListMusicObject = getIntent().getParcelableArrayListExtra(Constant.LIST_SONG_EXTRA);
        mSongName.setText(nameSong);

        mPlayer.reset();
        try {
            mPlayer.setDataSource(pathSong);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playPrevious() {
        mPlayer.reset();
        String path;
        if (currentPosition == 0) {
            path = mListMusicObject.get(0).getmPath();
        } else {
            path = mListMusicObject.get(--currentPosition).getmPath();
        }
        
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playNextMedia() {
        mPlayer.reset();
        String path;
        if (currentPosition == mListMusicObject.size() - 1) {
            path = mListMusicObject.get(mListMusicObject.size() - 1).getmPath();
        } else {

            path = mListMusicObject.get(++currentPosition).getmPath();
        }

        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopMedia() {
        mPlayer.stop();
    }
}
