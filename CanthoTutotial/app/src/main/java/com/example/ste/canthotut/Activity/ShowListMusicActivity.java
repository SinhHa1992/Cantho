package com.example.ste.canthotut.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ste.canthotut.Adapter.MusicAdapter;
import com.example.ste.canthotut.Constans.Constant;
import com.example.ste.canthotut.Model.MusicObject;
import com.example.ste.canthotut.R;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ShowListMusicActivity extends AppCompatActivity {

    private static final String TAG = "ShowListMusicActivity";

    private RecyclerView mListSong;             /*Recycler View show list song*/
    private List<MusicObject> mListDataMusic;   /*list music read from SD Card*/
    private MusicAdapter mAdapterMusic;         /*adapter show list music*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_music);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mListSong = (RecyclerView) findViewById(R.id.rvSong);
        mListDataMusic = new ArrayList<>();
        mAdapterMusic = new MusicAdapter(mListDataMusic);

        getFileMP3();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mListSong.setLayoutManager(layoutManager);
        mListSong.setAdapter(mAdapterMusic);
    }

    private void getFileMP3() {
        File home = new File(Constant.DIRECTORY_MUSIC_PATH);
        if (home.listFiles(new FileExtensionFilter()) != null &&
                home.listFiles(new FileExtensionFilter()).length > 0) {
            for (File file : home.listFiles(new FileExtensionFilter())) {
                mListDataMusic.add(new MusicObject(file.getName(), file.getPath()));
                Log.e(TAG, file.getName());
            }
        }
    }

    /*
    * Fill all file mp3 from SD Card
    * */
    private class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(Constant.FILLER_FILE));
        }
    }
}
