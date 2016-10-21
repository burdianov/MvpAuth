package com.testography.mvpauth.utils;

import android.app.Application;
import android.graphics.Typeface;

public class MvpAuthApplication extends Application {

    private static Typeface mPebasNeueRegular;

    public static Typeface getPebasNeueRegular() {
        return mPebasNeueRegular;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPebasNeueRegular = Typeface.createFromAsset(getApplicationContext()
                .getAssets(), "fonts/PTBebasNeueRegular.ttf");
    }
}
