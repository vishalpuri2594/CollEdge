package com.mycollege.mait;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Akshay on 1/10/2015.
 */
public class ActionBarCustomScrollView extends ScrollView {

    //Interface

    public interface OnScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }

    private OnScrollChangedListener mOnScrollChangedListener;
    //Constructors

    public ActionBarCustomScrollView(Context context) {
        super(context);
    }

    public ActionBarCustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActionBarCustomScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //Interface Method

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }


}
