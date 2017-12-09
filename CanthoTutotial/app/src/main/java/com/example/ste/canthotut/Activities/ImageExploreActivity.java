package com.example.ste.canthotut.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ste.canthotut.Adapters.PictureAdapter;
import com.example.ste.canthotut.Model.Picture;
import com.example.ste.canthotut.R;

import java.util.ArrayList;

/**
 * Create by Pham Hoai An on 9/12/2017
 * @version 1.0.1
 * */

public class ImageExploreActivity extends AppCompatActivity {
    private String mTitles[] = {
            "Img1",
            "Img2",
            "Img3",
            "Img4",
            "Img5",
            "Img6",
            "Img7",
            "Img8"
    };
    private Integer mImageList[] = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
    };
    private ArrayList<Picture> mPictures;
    private PictureAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_explore);

        prepareData();
        initListImage();
    }

    /**
     * This function initializes the object containing the image list.
     * */
    private void initListImage() {
        mRecyclerView = findViewById(R.id.rcv_image_gallery);

        mAdapter = new PictureAdapter(mPictures, getApplicationContext());
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * This function prepare date for picture list.
     * */
    private void prepareData() {
        mPictures = new ArrayList<>();
        Picture createList = new Picture();
        for (int i = 0; i < mTitles.length; i++) {
            createList.setmTitles(mTitles[i]);
            createList.setmImageId(mImageList[i]);
            mPictures.add(createList);
        }
    }

}
