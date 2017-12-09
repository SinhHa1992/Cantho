package com.example.ste.canthotut.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ste.canthotut.Object.MusicObject;
import com.example.ste.canthotut.Activity.PlayMusicActivity;
import com.example.ste.canthotut.R;

import java.util.List;

/**
 * Created by admin on 12/9/2017.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.DataViewHolder> {

    private List<MusicObject> mListMusic;
    private Context mContext;

    public MusicAdapter(List<MusicObject> mListMusic, Context mContext) {
        this.mListMusic = mListMusic;
        this.mContext = mContext;
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

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), PlayMusicActivity.class);
            intent.putExtra("pathSong", mListMusic.get(getAdapterPosition()).getmPath());
            intent.putExtra("nameSong", mListMusic.get(getAdapterPosition()).getmName());
            view.getContext().startActivity(intent);
        }
    }
}
