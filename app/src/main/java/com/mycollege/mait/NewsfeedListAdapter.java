package com.mycollege.mait;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Akshay on 1/8/2015.
 */
public class NewsfeedListAdapter extends SimpleAdapter {

  GlobalVariblesClass colorVar;
    TextView tit;
    LinearLayout newtxt;

    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    public NewsfeedListAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);


        tit = (TextView) view.findViewById(R.id.tv_nf_title);
        newtxt = (LinearLayout) view.findViewById(R.id.tv_list_new);


        tit.setTextColor(colorVar.ovColor);
        int fadedColor = changeAlpha(colorVar.ovColor,.25f);
        if (position % 3 == 1) {
            newtxt.setBackgroundColor(colorVar.ovColor);

        } else {
            newtxt.setVisibility(View.INVISIBLE);
        }
        if (position % 2 == 1) {
            view.setBackgroundColor(fadedColor);
        } else {
            view.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
    int changeAlpha(int color,float factor)
    { int newColor;
        int alpha = Math.round(Color.alpha(color)*factor);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        newColor = Color.argb(alpha,red,green,blue);
        return newColor;
    }
}
