package com.example.ste.canthotut.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.ste.canthotut.Adapter.ImageAdaperWithoutViewHolder;
import com.example.ste.canthotut.Adapter.ImageAdapterWithViewHolder;
import com.example.ste.canthotut.Model.Picture;
import com.example.ste.canthotut.R;

import java.util.ArrayList;
import java.util.List;

public class TestViewHolder extends AppCompatActivity {

    private ListView mList1;
    private ImageAdaperWithoutViewHolder mAdapter1;
    private List<Picture> mListPicture1;

    private ListView mList2;
    private ImageAdapterWithViewHolder mAdapter2;
    private List<Picture> mListPicture2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_holder);

        setupList1();
        setupList2();
    }

    private void setupList1() {
        mList1 = (ListView) findViewById(R.id.list1);
        mListPicture1 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mListPicture1.add(new Picture("http://hinhanhdepvip.com/wp-content/uploads/2016/07/hinh-anh-de-thuong-ve-tinh-yeu.jpg"));
            mListPicture1.add(new Picture("http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-xinh-cho-may-tinh-full-hd.jpg"));
            mListPicture1.add(new Picture("https://c1.staticflickr.com/5/4251/35009838590_c30ee4dbdd_b.jpg"));
            mListPicture1.add(new Picture("http://thuvienanhdep.net/wp-content/uploads/2015/09/bo-suu-tap-nhung-hinh-anh-girl-xinh-dang-yeu-de-thuong-nhat-nhe-8.jpg"));
            mListPicture1.add(new Picture("https://farm6.staticflickr.com/5334/8850827612_869358638d_z.jpg"));
        }
        mAdapter1 = new ImageAdaperWithoutViewHolder(this, R.layout.item_test_view_holder, mListPicture1);
        mList1.setAdapter(mAdapter1);

     //   mAdapter1.no
    }

    private void setupList2() {
        mList2 = (ListView) findViewById(R.id.list2);
        mListPicture2 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            mListPicture2.add(new Picture("http://hinhanhdepvip.com/wp-content/uploads/2016/07/hinh-anh-de-thuong-ve-tinh-yeu.jpg"));
            mListPicture2.add(new Picture("http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-xinh-cho-may-tinh-full-hd.jpg"));
            mListPicture2.add(new Picture("https://c1.staticflickr.com/5/4251/35009838590_c30ee4dbdd_b.jpg"));
            mListPicture2.add(new Picture("http://thuvienanhdep.net/wp-content/uploads/2015/09/bo-suu-tap-nhung-hinh-anh-girl-xinh-dang-yeu-de-thuong-nhat-nhe-8.jpg"));
            mListPicture2.add(new Picture("https://farm6.staticflickr.com/5334/8850827612_869358638d_z.jpg"));
        }
        mAdapter2 = new ImageAdapterWithViewHolder(this, R.layout.item_test_view_holder, mListPicture2);
        mList2.setAdapter(mAdapter2);
    }
}
