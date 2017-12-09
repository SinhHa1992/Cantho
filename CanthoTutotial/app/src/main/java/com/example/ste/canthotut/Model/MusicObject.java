package com.example.ste.canthotut.Model;

/**
 * Created by admin on 12/9/2017.
 */

public class MusicObject {
    private String mName;
    private String mPath;

    public MusicObject(String mName, String mPath) {
        this.mName = mName;
        this.mPath = mPath;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPath() {
        return mPath;
    }

    public void setmPath(String mPath) {
        this.mPath = mPath;
    }
}
