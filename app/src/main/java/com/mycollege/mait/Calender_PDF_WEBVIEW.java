package com.mycollege.mait;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;

public class Calender_PDF_WEBVIEW extends ActionBarActivity {
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_webview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


wv.loadUrl("http://docs.google.com/viewer?url=http%3A%2F%2Fipu.ac.in%2Facad_cal%2Facadcal200814.pdf");

    }
}
