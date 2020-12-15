package com.mycollege.mait;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Home_unlogged extends ActionBarActivity implements Animation.AnimationListener {

    Button blogin, abt_mait, button2, button3, button4, button5, button6, button7, button8, button9, abt_mait0;
    Animation slide_from_left1, slide_from_left2, slide_from_left3, slide_from_left4, slide_from_left5, slide_from_right1, slide_from_right2, slide_from_right3, slide_from_right4, slide_from_right5, button_movement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lay_unlogged);
        getSupportActionBar().hide();


        InitializeAllButtons();
        loadAnimations();
        setAnimationListenerForButtons();
        assignOffsets();
        startAnimationforButtons();

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent("android.intent.action.LOGIN");
                startActivity(login);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }

        });
        abt_mait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent act = new Intent("android.intent.action.ABOUTMAIT");
                startActivity(act);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }
        });

      /*  vf_image = (ViewFlipper) findViewById(R.id.flipper_image);
        vf_image.setInAnimation(this, android.R.anim.fade_in);
        vf_image.setFlipInterval(5000);
        vf_image.setOutAnimation(this, android.R.anim.fade_out);
        vf_image.setAutoStart(true);
*/



        /*aboutMait = (LinearLayout) findViewById(R.id.b_br_about_mait);
        campusDrive = (LinearLayout) findViewById(R.id.b_br_campus_drive);
		achieve = (LinearLayout) findViewById(R.id.b_br_achievements);
		admPro = (LinearLayout) findViewById(R.id.b_br_adm_pro);
		loc = (LinearLayout) findViewById(R.id.b_br_location);
		placement = (LinearLayout) findViewById(R.id.b_br_placement);

		ll_b = (LinearLayout) findViewById(R.id.ll_unlogged_button);
		ll_vp = (LinearLayout) findViewById(R.id.ll_unlogged_fragment);


		ll_vp.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					if (gone == false) {
						ll_b.setVisibility(View.GONE);
						gone = true;
					} else {
						ll_b.setVisibility(View.VISIBLE);
						gone = false;

					}
				}
				return true;
			}
		});*/

    }


    private void InitializeAllButtons() {
        //slide from left buttons
        abt_mait = (Button) findViewById(R.id.b_ul1);
        button2 = (Button) findViewById(R.id.b_ul2);
        button3 = (Button) findViewById(R.id.b_ul3);
        button4 = (Button) findViewById(R.id.b_ul4);
        button5 = (Button) findViewById(R.id.b_ul5);

        //slide from right buttons
        button6 = (Button) findViewById(R.id.b_ul6);
        button7 = (Button) findViewById(R.id.b_ul7);
        button8 = (Button) findViewById(R.id.b_ul8);
        button9 = (Button) findViewById(R.id.b_ul9);
        abt_mait0 = (Button) findViewById(R.id.b_ul10);
        //login button
        blogin = (Button) findViewById(R.id.ul_login);
    }


    private void loadAnimations() {
        slide_from_left1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_left);
        slide_from_left2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_left);
        slide_from_left3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_left);
        slide_from_left4 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_left);
        slide_from_left5 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_left);
        slide_from_right1 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);
        slide_from_right2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);
        slide_from_right3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);
        slide_from_right4 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);
        slide_from_right5 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_from_right);

    }

    private void assignOffsets() {
        slide_from_left2.setStartOffset(100);
        slide_from_left3.setStartOffset(200);
        slide_from_left4.setStartOffset(300);
        slide_from_left5.setStartOffset(400);
        slide_from_right2.setStartOffset(100);
        slide_from_right3.setStartOffset(200);
        slide_from_right4.setStartOffset(300);
        slide_from_right5.setStartOffset(400);

    }

    private void setAnimationListenerForButtons() {

        slide_from_left1.setAnimationListener(this);
        slide_from_left2.setAnimationListener(this);
        slide_from_left3.setAnimationListener(this);
        slide_from_left4.setAnimationListener(this);
        slide_from_left5.setAnimationListener(this);
        slide_from_right1.setAnimationListener(this);
        slide_from_right2.setAnimationListener(this);
        slide_from_right3.setAnimationListener(this);
        slide_from_right4.setAnimationListener(this);
        slide_from_right5.setAnimationListener(this);
    }

    private void startAnimationforButtons() {
        abt_mait.startAnimation(slide_from_left1);
        button2.startAnimation(slide_from_left2);
        button3.startAnimation(slide_from_left3);
        button4.startAnimation(slide_from_left4);
        button5.startAnimation(slide_from_left5);
        button6.startAnimation(slide_from_right1);
        button7.startAnimation(slide_from_right2);
        button8.startAnimation(slide_from_right3);
        button9.startAnimation(slide_from_right4);
        abt_mait0.startAnimation(slide_from_right5);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }





	/*public void click(View view) {
        Fragment fr = null;

		FragmentManager fm = getSupportFragmentManager();

		FragmentTransaction fragmentTransaction = fm.beginTransaction();
		
		if (view == findViewById(R.id.b_br_about_mait)) {
			fr = new MAIT_AboutMait();
		} else if (view == findViewById(R.id.b_br_campus_drive)) {
			fr = new MAIT_CampusDrive();
		} else if (view == findViewById(R.id.b_br_achievements)) {

		} else if (view == findViewById(R.id.b_br_adm_pro)) {

		} else if (view == findViewById(R.id.b_br_location)) {

		} else if (view == findViewById(R.id.b_br_placement)) {

	}

		
		fragmentTransaction.replace(R.id.fragment_unlogged, fr);
		fragmentTransaction.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		getMenuInflater().inflate(R.menu.home_unlogged, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_login) {
			Intent login = new Intent("android.intent.action.LOGIN");
			startActivity(login);

		}
		return super.onOptionsItemSelected(item);
	}*/

}
