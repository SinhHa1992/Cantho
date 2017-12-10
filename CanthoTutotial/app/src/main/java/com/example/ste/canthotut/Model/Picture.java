package com.example.ste.canthotut.Model;

/**
 * Created by phamh on 12/9/2017.
 * @version 1.0.1
 */

public class Picture {

    private String  mTitles;
    private Integer mImageId;
    private String url;

    public Picture() {

    }

    public Picture(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getmTitles() {
        return mTitles;
    }

    public Integer getmImageId() {
        return mImageId;
    }

    public void setmTitles(String mTitles) {
        this.mTitles = mTitles;
    }

    public void setmImageId(Integer mImageId) {
        this.mImageId = mImageId;
    }
}
