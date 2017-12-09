package com.example.ste.canthotut.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ste.canthotut.Activity.PlayMusicActivity;
import com.example.ste.canthotut.Constant.Constant;
import com.example.ste.canthotut.Model.MusicObject;
import com.example.ste.canthotut.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/9/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.DataViewHolder> {

    private List<MusicObject> mListMusic;

    public MusicAdapter(List<MusicObject> mListMusic) {
        this.mListMusic = mListMusic;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
        return new DataViewHolder(item);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        holder.mTextSongName.setText(mListMusic.get(position).getmName());
    }

    @Override
    public int getItemCount() {
        return mListMusic.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextSongName;

        DataViewHolder(View itemView) {
            super(itemView);
            mTextSongName = (TextView) itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(this);
        }

        /*
        * onClick send pathSong, nameSong current & listSong
        * from ShowListMusicActivity to PlayMusicActivity
        * */
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), PlayMusicActivity.class);
            intent.putParcelableArrayListExtra(Constant.LIST_SONG_EXTRA, (ArrayList<? extends Parcelable>) mListMusic);
            intent.putExtra(Constant.PATH_SONG_EXTRA, mListMusic.get(getAdapterPosition()).getmPath());
            intent.putExtra(Constant.NAME_SONG_EXTRA, mListMusic.get(getAdapterPosition()).getmName());
            view.getContext().startActivity(intent);
        }
    }
}
