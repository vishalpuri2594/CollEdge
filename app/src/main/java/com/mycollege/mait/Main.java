package com.mycollege.mait;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class Main extends Activity{
boolean login;
Intent newAcitivty;
GlobalVariblesClass colorVar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		SharedPreferences sp = getSharedPreferences("login",
				Activity.MODE_PRIVATE);
		login = sp.getBoolean("state", false);
        SharedPreferences sp2 = getSharedPreferences("abcolor",
                Activity.MODE_PRIVATE);
        colorVar.ovColor = sp2.getInt("color", 0xFF666666);

		
		if(login == true){
			newAcitivty = new Intent("android.intent.action.HOMELOGGED");
			startActivity(newAcitivty);
		}else{
			newAcitivty = new Intent("android.intent.action.HOMEUNLOGGED");
			startActivity(newAcitivty);
		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
}
