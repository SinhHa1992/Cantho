package com.example.ste.canthotut.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ste.canthotut.Model.Picture;
import com.example.ste.canthotut.R;

import java.util.ArrayList;

/**
 * Created by phamh on 12/9/2017.
 * @version 1.0.1
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private ArrayList<Picture> mGallerys;
    private Context mContext;

    public PictureAdapter(ArrayList<Picture> mGallerys, Context mContext) {
        this.mGallerys = mGallerys;
        this.mContext = mContext;
    }

    @Override
    public PictureAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell_gallary, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureAdapter.ViewHolder holder, int position) {
        holder.mTitle.setText(mGallerys.get(position).getmTitles());
        holder.mImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.mImg.setImageResource((mGallerys.get(position).getmImageId()));

    }

    @Override
    public int getItemCount() {
        return mGallerys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private ImageView mImg;
        public ViewHolder(View view) {
            super(view);
            mTitle = (TextView)view.findViewById(R.id.title);
            mImg = (ImageView) view.findViewById(R.id.img);
        }
    }
}
