package com.example.ste.canthotut.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.ste.canthotut.Constant.Constant;
import com.example.ste.canthotut.Download.DownloadFile;
import com.example.ste.canthotut.Model.Picture;
import com.example.ste.canthotut.R;

import java.io.File;
import java.util.List;

/**
 * Created by admin on 12/10/2017.
 */

public class ImageAdaperWithoutViewHolder extends ArrayAdapter<Picture> {
    private Context mContext;
    private int mResource;
    private List<Picture> mListPicture;

    public ImageAdaperWithoutViewHolder(@NonNull Context context, int resource, @NonNull List<Picture> mListPicture) {
        super(context, resource, mListPicture);
        this.mContext = context;
        this.mResource = resource;
        this.mListPicture = mListPicture;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test_view_holder, parent, false);

        ImageView img = (ImageView) item.findViewById(R.id.imgMusic);
        //Glide.with(mContext).load(mListPicture.get(position).getUrl()).into(img);
        //Log.e("log", mListPicture.get(position).getUrl());
        String temp = mListPicture.get(position).getUrl();
        int lastIndex = temp.length();
        int firstIndex = temp.lastIndexOf("/");
        String fileName = temp.substring(firstIndex, lastIndex);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.execute(mListPicture.get(position).getUrl(), fileName);

        File imgFile = new File(Constant.DIRECTORY_PICTURE_PATH + fileName);

        if (imgFile.exists()) {
            //Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            Bitmap myBitmap = resizeBitmap(imgFile.getPath(), 100, 100);
            img.setImageBitmap(myBitmap);
        }

        return item;
    }

    public Bitmap resizeBitmap(String photoPath, int targetW, int targetH) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        }

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        return BitmapFactory.decodeFile(photoPath, bmOptions);
    }
}
