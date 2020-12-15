package com.mycollege.mait;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Home_logged extends ActionBarActivity implements NewsFeedListFragment.Callbacks {

    Intent b_action;
    GlobalVariblesClass colorVar;
	ViewPager viewpager = null;
	boolean login;
	private String[] nDrawerListOpen = { "Home" };
	private String[] nDrawerList = { "Home", "FAQ's", "About Us" };
	private DrawerLayout nDrawer;
	private ListView nDrawerListView;
	private ActionBarDrawerToggle nDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
    SettingsClass ts;
    int color;
    private final Handler handler = new Handler();
    private Drawable oldBackground = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        {
            SharedPreferences sp = getSharedPreferences("login",
                    Activity.MODE_PRIVATE);
            login = sp.getBoolean("state", false);
        }
        {
            SharedPreferences cl = getSharedPreferences("abcolor",
                    Activity.MODE_PRIVATE);
            color = cl.getInt("color", 0xFF666666);
            Log.e("Logged Color : "," "+ color);
           changeColor(color);

            colorVar.ovColor = color;

        }

		setContentView(R.layout.lay_home);
		viewpager = (ViewPager) findViewById(R.id.pager);

		FragmentManager fragmentmanager = getSupportFragmentManager();

		viewpager.setAdapter(new MyAdapter(fragmentmanager));

		nDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		/*nDrawerListView = (ListView) findViewById(R.id.left_drawer);*/

		mTitle = mDrawerTitle = getTitle();
		nDrawerToggle = new ActionBarDrawerToggle(this, nDrawer,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getSupportActionBar().setTitle(mTitle);

			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle(mDrawerTitle);

			}
		};
		nDrawer.setDrawerListener(nDrawerToggle);
		nDrawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

		/*nDrawerListView.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, nDrawerList));*/
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

	}

	public void click(View arg0) {
		// TODO Auto-generated method stub
		Intent intent;
		

		switch (arg0.getId()) {

		case R.id.b_calender:
			intent = new Intent("android.intent.action.CALENDER");
			startActivity(intent);
			break;
		case R.id.b_notice:
            intent = new Intent("android.intent.action.NOTICEBOARD");
            startActivity(intent);
			break;
		case R.id.b_societies:

			break;
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		nDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		nDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.home_logged, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_notice) {
            Intent th = new Intent("android.intent.action.NOTIFICATION");
            startActivity(th);
			return true;
		}
		if (id == R.id.action_logout) {
			SharedPreferences sp = getSharedPreferences("login",
					Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = sp.edit();
			editor.putBoolean("state", false);
			editor.commit();
			startActivity(Home_logged.this, Main.class);
		}

		if (id == R.id.action_settings) {
            Intent th = new Intent("android.intent.action.THEMESELECTOR");
            startActivity(th);
			return true;
		}

		if (nDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static void startActivity(Activity current, Class dest) {

		Intent intent = new Intent();
		intent.setClass(current, dest);
		current.finish();
		current.startActivity(intent);

	}

	public static void restartActivity(Activity act) {

		Intent intent = new Intent();
		intent.setClass(act, act.getClass());
		act.finish();
		act.startActivity(intent);

	}
    public void changeColor(int newColor) {

        Log.e("CMethod : "," Change Color method called in logged : "+ newColor);
        // change ActionBar color just if an ActionBar is available
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Log.e("Build Version > HoneyComb : "," "+ Build.VERSION.SDK_INT);
            Drawable colorDrawable = new ColorDrawable(newColor);
            Drawable bottomDrawable = getResources().getDrawable(R.drawable.actionbar_bottom);
            LayerDrawable ld = new LayerDrawable(new Drawable[] { colorDrawable, bottomDrawable });

            if (oldBackground == null) {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    ld.setCallback(drawableCallback);
                } else {
                    getSupportActionBar().setBackgroundDrawable(ld);

                }

            } else {
                Log.e("Build Version < HoneyComb : "," "+ Build.VERSION.SDK_INT);
                TransitionDrawable td = new TransitionDrawable(new Drawable[] { oldBackground, ld });

                // workaround for broken ActionBarContainer drawable handling on
                // pre-API 17 builds
                // https://github.com/android/platform_frameworks_base/commit/a7cc06d82e45918c37429a59b14545c6a57db4e4
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    td.setCallback(drawableCallback);
                } else {
                    getSupportActionBar().setBackgroundDrawable(td);

                }

                td.startTransition(200);

            }

            oldBackground = ld;

            // http://stackoverflow.com/questions/11002691/actionbar-setbackgrounddrawable-nulling-background-from-thread-handler
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);

        }



    }
    private Drawable.Callback drawableCallback = new Drawable.Callback() {
        @Override
        public void invalidateDrawable(Drawable who) {
            getSupportActionBar().setBackgroundDrawable(who);
        }

        @Override
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
            handler.postAtTime(what, when);
        }

        @Override
        public void unscheduleDrawable(Drawable who, Runnable what) {
            handler.removeCallbacks(what);
        }

    };

    @Override
    public void onItemSelected(String id) {
        Intent detailIntent = new Intent(this,NewsFeedDetailActivity.class);
        detailIntent.putExtra(NewsFeedDetailFragment.ARG_ITEM_ID, id);
        startActivity(detailIntent);

    }
}

class MyAdapter extends FragmentStatePagerAdapter {

	public MyAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {

		Fragment fragment = null;
		if (arg0 == 0) {
			fragment = new NewsFeedListFragment();
		}
		if (arg0 == 1) {
			fragment = new MAIT();
		}
		if (arg0 == 2) {
			fragment = new StudentSection();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	public CharSequence getPageTitle(int position) {
		String title = new String();
		if (position == 0) {
			return "News Feed";
		}
		if (position == 1) {
			return "MAIT";
		}
		if (position == 2) {
			return "Student Section";
		}
		return title;

	}

}
