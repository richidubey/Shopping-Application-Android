package com.example.shopnow;

import android.graphics.Bitmap;

/**
 * Created by user on 11-07-2017.
 */

public class Items {
    private Bitmap mImageBitmap;
    private int mImgID;
    private String mNewsHead;
    private String mDateofPublication;
    private String mSection;
    private String mWebUrl;

    Items(Bitmap imagebitmap,String newshead,String dateofpublication,String section,String weburl){
        mImageBitmap=imagebitmap;
        mNewsHead=newshead;
        mDateofPublication=dateofpublication;
        mSection=section;
        mWebUrl=weburl;
    }

    Items(int imgid,String newshead,String dateofpublication,String section,String weburl){
        mImgID=imgid;
        mNewsHead=newshead;
        mDateofPublication=dateofpublication;
        mSection=section;
        mWebUrl=weburl;
    }

    public Bitmap getmImageBitmap() {
        return mImageBitmap;
    }
    public int getmImgID(){
        return mImgID;
    }
    public String getmNewsHead() {
        return mNewsHead;
    }
    public String getmDateofPublication() {
        return mDateofPublication;
    }
    public String getmSection() {
        return mSection;
    }

    public String getmWebUrl() {
        return mWebUrl;
    }
}
