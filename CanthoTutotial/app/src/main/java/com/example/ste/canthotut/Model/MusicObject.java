package com.example.ste.canthotut.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 12/9/2017.
 */

public class MusicObject implements Parcelable {
    public static final Creator<MusicObject> CREATOR
            = new Creator<MusicObject>() {
        public MusicObject createFromParcel(Parcel in) {
            return new MusicObject(in);
        }

        public MusicObject[] newArray(int size) {
            return new MusicObject[size];
        }
    };
    private String mName;
    private String mPath;

    public MusicObject(String mName, String mPath) {
        this.mName = mName;
        this.mPath = mPath;
    }

    private MusicObject(Parcel in) {
        mName = in.readString();
        mPath = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(mName);
        out.writeString(mPath);
    }
}
