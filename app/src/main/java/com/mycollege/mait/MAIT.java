package com.mycollege.mait;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MAIT extends Fragment {

    /* Button notice, calender, ab_faculty, society; */
    Intent b_action;
    TextView board,ender,faculty,ieties;
    ImageView bcal;
    GlobalVariblesClass colorVar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view =inflater.inflate(R.layout.lay_mait, container, false);


        board = (TextView) view.findViewById(R.id.tv_mait_board);
        ender = (TextView) view.findViewById(R.id.tv_mait_ender);
        faculty = (TextView) view.findViewById(R.id.tv_mait_faculty);
        ieties  = (TextView) view.findViewById(R.id.tv_mait_ieties);

        /*bcal= (ImageView) view.findViewById(R.id.iv_soc);
        bcal.setColorFilter(Color.argb(100,Color.red(colorVar.ovColor),Color.green(colorVar.ovColor),Color.blue(colorVar.ovColor)));*/


        faculty.setTextColor(colorVar.ovColor);
        ieties.setTextColor(colorVar.ovColor);
        ender.setTextColor(colorVar.ovColor);
        board.setTextColor(colorVar.ovColor);

		/*
         * notice = (Button) container.findViewById(R.id.b_notice); calender =
		 * (Button) container.findViewById(R.id.b_calender); ab_faculty =
		 * (Button) container.findViewById(R.id.b_ab_faculty); society =
		 * (Button) container.findViewById(R.id.b_society);
		 */

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
