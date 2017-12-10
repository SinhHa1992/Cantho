package com.example.ste.canthotut.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.ste.canthotut.Model.SpacePhotoModel;
import com.example.ste.canthotut.R;

import java.util.ArrayList;

/**
 * Created by phamh on 12/9/2017.
 * @version 1.0.1
 */

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {
    private Context mContext;
    private SpacePhotoModel[] mSpacePhotos;

    public ImageGalleryAdapter(Context mContext, SpacePhotoModel[] mSpacePhotos) {
        this.mContext = mContext;
        this.mSpacePhotos = mSpacePhotos;
    }

    @Override
    public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View photoView = inflater.inflate(R.layout.item_cell_gallary, parent, false);
        ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {
        SpacePhotoModel spacePhoto = mSpacePhotos[position];
        holder.bind(spacePhoto);
    }

    @Override
    public int getItemCount() {
        return (mSpacePhotos.length);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView mPhotoImageView;

        private MyViewHolder(View itemView) {
            super(itemView);
            mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
            itemView.setOnClickListener(this);
        }

        private void bind(SpacePhotoModel spacePhoto){
            Glide.with(mContext)
                    .load(spacePhoto.getUrl())
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.ic_file_download_black_24dp).into(mPhotoImageView);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

//            if (position != RecyclerView.NO_POSITION) {
//                SpacePhotoModel spacePhoto = mSpacePhotos[position];
//                Intent intent = new Intent(mContext, SpacePhotoActivity.class);
//                intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
//                mContext.startActivity(intent);
//            }
        }
    }
}
