package com.example.harta2;
import com.example.harta2.MenuActivity;
import com.example.harta2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class SplashActivity extends Activity{

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getActionBar().hide();
        setContentView(R.layout.activity_splash);
  
        Thread splash = new Thread(){
        	public void run(){
        		try{
        			sleep(3000);
        		}
        		catch(Exception ex){
        			ex.printStackTrace();
        			
        		}
        		finally{
        	    	Intent i = new Intent(SplashActivity.this, MenuActivity.class);
        	    	startActivity(i);
        		}
        	}
        };
        splash.start();
    }
}
