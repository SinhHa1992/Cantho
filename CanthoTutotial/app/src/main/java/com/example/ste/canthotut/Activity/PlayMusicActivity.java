package com.example.ste.canthotut.Activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.ste.canthotut.R;

public class PlayMusicActivity extends AppCompatActivity {

    private VideoView mViewPlayMusic;
    private MediaController mMediaControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        initWidget();
        setUpVideoView();
    }

    private void initWidget() {
        mViewPlayMusic = (VideoView) findViewById(R.id.vvPlayMusic);
    }

    private void setUpVideoView() {
        mMediaControl = new MediaController(this);
        mMediaControl.setMediaPlayer(mViewPlayMusic);
        mViewPlayMusic.setMediaController(mMediaControl);
        String path = getIntent().getStringExtra(ShowListMusicActivity.PATH_EXTRA);
        Log.e("logg", path);
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
