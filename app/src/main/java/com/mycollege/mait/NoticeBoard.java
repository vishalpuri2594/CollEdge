package com.mycollege.mait;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Akshay on 1/10/2015.
 */
public class NoticeBoard extends ActionBarActivity {

    private ColorDrawable mActionBarBackgroundDrawable;
    int currentColor;
    TextView board;
    LinearLayout llstrip;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_noticeboard);
        SharedPreferences sp = getSharedPreferences("abcolor",
                Activity.MODE_PRIVATE);
        currentColor = sp.getInt("color", 0xFF666666);

        llstrip = (LinearLayout) findViewById(R.id.ll_mait_strip);
        board = (TextView) findViewById(R.id.tv_mait_board2);

        board.setTextColor(currentColor);
        llstrip.setBackgroundColor(currentColor);

        mActionBarBackgroundDrawable = new ColorDrawable(currentColor);
        mActionBarBackgroundDrawable.setAlpha(0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);


        ((ActionBarCustomScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);

        Drawable.Callback mDrawableCallback = new Drawable.Callback() {
            @Override
            public void invalidateDrawable(Drawable who) {
                getSupportActionBar().setBackgroundDrawable(who);
            }

            @Override
            public void scheduleDrawable(Drawable who, Runnable what, long when) {
            }

            @Override
            public void unscheduleDrawable(Drawable who, Runnable what) {
            }
        };
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActionBarBackgroundDrawable.setCallback(mDrawableCallback);
        }
    }

    private ActionBarCustomScrollView.OnScrollChangedListener mOnScrollChangedListener = new ActionBarCustomScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int headerHeight = findViewById(R.id.image_header).getHeight() - getSupportActionBar().getHeight();
            final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
            final int newAlpha = (int) (ratio * 255);
            mActionBarBackgroundDrawable.setAlpha(newAlpha);
        }
    };
}
