package com.mycollege.mait;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MAIT_AboutMait extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay__mait_aboutmait);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
    }
}
