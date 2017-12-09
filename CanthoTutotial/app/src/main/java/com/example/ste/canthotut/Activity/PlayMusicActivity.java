package com.example.ste.canthotut.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.ste.canthotut.Constans.Constant;
import com.example.ste.canthotut.R;

public class PlayMusicActivity extends AppCompatActivity {

    private static final String TAG = "PlayMusicActivity";

    private VideoView mViewPlayMusic;
    private MediaController mMediaControl;

    private TextView mSongName;
    private Button mBtnPlay;
    private Button mBtnPause;
    private Button mBtnNext;
    private Button mBtnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initWidget();
        setUpVideoView();
    }

    private void initWidget() {
        mViewPlayMusic = (VideoView) findViewById(R.id.vvMusic);
    }

    private void setUpVideoView() {
        mMediaControl = new MediaController(this);
        mMediaControl.setMediaPlayer(mViewPlayMusic);
        mViewPlayMusic.setMediaController(mMediaControl);

        String path = getIntent().getStringExtra(Constant.PATH_SONG_EXTRA);
        Log.e(TAG, path);

        if (path != null) {
            mViewPlayMusic.setVideoPath(path);
        }

        mViewPlayMusic.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mViewPlayMusic.start();
                mediaPlayer.start();
                mMediaControl.show();
            }
        });
    }
}
