package com.example.ste.canthotut.Model;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by phamh on 12/9/2017.
 *
 * @version 1.0.1
 */

public class SpacePhotoModel implements Parcelable {
    private String mUrl;
    private String mTitle;

    public SpacePhotoModel(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected SpacePhotoModel(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<SpacePhotoModel> CREATOR = new Creator<SpacePhotoModel>() {
        @Override
        public SpacePhotoModel createFromParcel(Parcel in) {
            return new SpacePhotoModel(in);
        }

        @Override
        public SpacePhotoModel[] newArray(int size) {
            return new SpacePhotoModel[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static SpacePhotoModel[] getSpacePhotos() {
        return new SpacePhotoModel[]{
                new SpacePhotoModel("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SpacePhotoModel("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SpacePhotoModel("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SpacePhotoModel("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SpacePhotoModel("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SpacePhotoModel("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
                new SpacePhotoModel("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SpacePhotoModel("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SpacePhotoModel("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SpacePhotoModel("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SpacePhotoModel("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SpacePhotoModel("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
                new SpacePhotoModel("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SpacePhotoModel("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SpacePhotoModel("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SpacePhotoModel("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SpacePhotoModel("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SpacePhotoModel("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
                new SpacePhotoModel("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SpacePhotoModel("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SpacePhotoModel("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SpacePhotoModel("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SpacePhotoModel("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SpacePhotoModel("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}