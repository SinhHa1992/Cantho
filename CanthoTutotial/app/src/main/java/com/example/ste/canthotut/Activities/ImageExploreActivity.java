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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_explore);
        initListImage();
    }

    /**
     * This function initializes the object containing the image list.
     * */
    private void initListImage() {
        ArrayList<Picture> pictures = prepareData();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rcv_image_gallery);
        PictureAdapter adapter = new PictureAdapter(pictures, getApplicationContext());

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    /**
     * This function prepare date for picture list.
     * */
    private ArrayList<Picture> prepareData() {
        ArrayList<Picture> theimage = new ArrayList<>();

        for (int i = 0; i < mTitles.length; i++) {
            Picture createList = new Picture();
            createList.setmTitles(mTitles[i]);
            createList.setmImageId(mImageList[i]);
            theimage.add(createList);
        }
        return theimage;
    }

}
