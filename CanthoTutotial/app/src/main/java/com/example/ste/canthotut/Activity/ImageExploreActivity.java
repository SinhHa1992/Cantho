package com.example.ste.canthotut.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ste.canthotut.Adapter.ImageGalleryAdapter;
import com.example.ste.canthotut.Model.SpacePhotoModel;
import com.example.ste.canthotut.R;

import java.util.ArrayList;

/**
 * Create by Pham Hoai An on 9/12/2017
 * @version 1.0.1
 * */

public class ImageExploreActivity extends AppCompatActivity {
    private ImageGalleryAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_explore);
        mRecyclerView = (RecyclerView) findViewById(R.id.rcv_image_gallery);

        initListImage();
    }

    /**
     * This function initializes the object containing the image list.
     * */
    private void initListImage() {
        mAdapter = new ImageGalleryAdapter(this, SpacePhotoModel.getSpacePhotos());
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
