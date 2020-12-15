package com.mycollege.mait;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import net.sf.andpdf.pdfviewer.PdfViewerActivity;

public class Calender extends ActionBarActivity {
    private static final String TAG_TITLE = "title";
    private static final String TAG_DESC = "desc";
    private static final String TAG_IMAGE = "image";

    ListView lv;
    private ArrayList<HashMap<String, Object>> data;

    private ColorDrawable mActionBarBackgroundDrawable;
    int currentColor;
    TextView ender;
    LinearLayout llstrip;
    File[] imagelist;
    AssetManager asm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_calender);

        lv = (ListView) findViewById(R.id.lv_cal);
        lv.setBackgroundColor(Color.WHITE);
        asm = getAssets();


       /* imagelist = pdf.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return ((name.endsWith(".pdf")));
            }*/
        /*});*/


        SharedPreferences sp = getSharedPreferences("abcolor",
                Activity.MODE_PRIVATE);
        currentColor = sp.getInt("color", 0xFF666666);

        llstrip = (LinearLayout) findViewById(R.id.ll_mait_strip_cal);
        llstrip.setBackgroundColor(currentColor);

        ender = (TextView) findViewById(R.id.tv_mait_ender2);
        ender.setTextColor(currentColor);

        mActionBarBackgroundDrawable = new ColorDrawable(currentColor);
        mActionBarBackgroundDrawable.setAlpha(0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);


        PrepareData();

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                R.layout.listlay_cal, new String[]{TAG_TITLE, TAG_DESC, TAG_IMAGE}, new int[]{R.id.tv_list_cal_title,
                R.id.tv_list_cal_desc, R.id.iv_list_cal_image});
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id == 0) {


                    File f = new File(getCacheDir() + "/acad_cal.pdf");
                    if (!f.exists()) {
                        try {

                            InputStream is = getAssets().open("acad_cal.pdf");
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();


                            FileOutputStream fos = new FileOutputStream(f);
                            fos.write(buffer);
                            fos.close();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    openPdfIntent(f.getAbsolutePath());


                } else if (position == 1) {

                    File f2 = new File(getCacheDir() + "/holi_cal.pdf");
                    if (!f2.exists()) {
                        try {

                            InputStream is = getAssets().open("holi_cal2.pdf");
                            int size = is.available();
                            byte[] buffer = new byte[size];
                            is.read(buffer);
                            is.close();


                            FileOutputStream fos = new FileOutputStream(f2);
                            fos.write(buffer);
                            fos.close();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    openPdfIntent(f2.getAbsolutePath());
                }

            }
        });

    }

    private void PrepareData() {
        data = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> item;
        item = new HashMap<String, Object>();
        item.put(TAG_TITLE, "Academic Calender");
        item.put(TAG_DESC, "FOR THE\nUNIVERSITY SCHOOLS &\nAFFILIATED INSTITUTIONS\n(for the Academic Session 2014-2015) ");
        item.put(TAG_IMAGE, R.drawable.marker_1);
        data.add(item);
        item = new HashMap<String, Object>();
        item.put(TAG_TITLE, "Holidays");
        item.put(TAG_DESC, "LIST OF \nOFFICIAL HOLIDAYS\nAND\nRESTRICTED HOLIDAYS");
        item.put(TAG_IMAGE, R.drawable.marker_2);
        data.add(item);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this, new Intent(this, Home_logged.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPdfIntent(String path) {
        try {
            final Intent intent = new Intent(Calender.this, PDFNewActivity.class);
            intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, path);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
