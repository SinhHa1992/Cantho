package com.example.ste.canthotut.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

    private Button mBtnPause;
    private Button mBtnNext;
    private Button mBtnPrevious;
    private SeekBar mSeekBar;                      /*song duration */

    private MediaPlayer mPlayer;                   /*play music*/
    private List<MusicObject> mListMusicObject;    /*list song from ShowListMusicActivity*/
    private int currentPosition;                   /*position when click item from ShowListMusicActivity*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initWidget();
        playMedia();
    }

    /*
    *   initialize SeekBar, Button & setOnClick for button
    * */
    private void initWidget() {
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSongName = (TextView) findViewById(R.id.tvSongName);
        mBtnNext = (Button) findViewById(R.id.btnNext);
        mBtnPause = (Button) findViewById(R.id.btnPause);
        mBtnPrevious = (Button) findViewById(R.id.btnPrevious);

        mBtnNext.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnPrevious.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPause:
                pauseMedia();
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
     * Auto play song when click item from ShowListMusicActivity
     * pathSong: path from item ShowListMusicActivity
     * nameSong: name from item ShowListMusicActivity
     */
    private void playMedia() {
        mPlayer = new MediaPlayer();
        mListMusicObject = new ArrayList<>();
        updateSeekbar();

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

    /**
     * play previous song
     * */
    private void playPrevious() {
        mPlayer.reset();
        mSeekBar.setProgress(0);
        String path;
        if (currentPosition == 0) {
            path = mListMusicObject.get(0).getmPath();
        } else {
            path = mListMusicObject.get(--currentPosition).getmPath();
        }
        mSongName.setText(mListMusicObject.get(currentPosition).getmName());
        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * play next song
     * */
    private void playNextMedia() {
        mPlayer.reset();
        mSeekBar.setProgress(0);
        String path;
        if (currentPosition == mListMusicObject.size() - 1) {
            path = mListMusicObject.get(mListMusicObject.size() - 1).getmPath();
        } else {
            path = mListMusicObject.get(++currentPosition).getmPath();
        }
        mSongName.setText(mListMusicObject.get(currentPosition).getmName());

        try {
            mPlayer.setDataSource(path);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * pause current song
     * */
    private void pauseMedia() {
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
            mBtnPause.setText(R.string.play);
        } else {
            mPlayer.start();
            mBtnPause.setText(R.string.pause);
        }
    }

    /**
     * Updating SeekBar progress
     * */
    private void updateSeekbar() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                float timeDuration = mPlayer.getDuration();
                float currentDuration = mPlayer.getCurrentPosition();

                float progress = (currentDuration / timeDuration) * 100;

                mSeekBar.setProgress((int) progress);
                handler.postDelayed(this, 100);
            }
        };

        handler.postDelayed(runnable, 100);
    }

    /**
     * clear mListMusicObject, SeekBar & MediaPlayer
     * */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mListMusicObject.clear();
        mSeekBar.setProgress(0);
        mPlayer.stop();
        mPlayer.release();
    }
}
