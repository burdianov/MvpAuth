package com.testography.mvpauth.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class TitleTextView extends AppCompatTextView {

    public TitleTextView(Context context) {
        super(context);
        setTypeface(context);
    }

    public TitleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(context);
    }

    public TitleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTypeface(context);
    }

    private void setTypeface(Context context) {
        if (context != null && !isInEditMode()) {
            setTypeface(MvpAuthApplication.getPebasNeueRegular());
        }
    }
}
