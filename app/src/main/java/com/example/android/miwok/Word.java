package com.example.android.miwok;

import android.graphics.drawable.Drawable;

/**
 * Created by David on 2/23/2018.
 */

public class Word {
    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int Image){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage = Image;
    }
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }
    public int getImageResourceId(){
        return mImage;
    }
    public boolean hasImage(){
        return mImage != NO_IMAGE_PROVIDED;
    }
}
