package com.example.harta2;

import java.io.File;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class MenuActivity extends ActionBarActivity{
	
	public final static String DATABASE_NAME = "turism.db"; 
	DrawerLayout mDLayout;
	ListView list;
	@SuppressWarnings("deprecation")
	ActionBarDrawerToggle drawerT;
	String title = "";

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
     
        
        title = (String) getTitle();
        mDLayout = (DrawerLayout) findViewById(R.id.drawer_layout); //activity_menu.xml e drawer_layout
        list = (ListView) findViewById(R.id.drawer_list); 
        drawerT = new ActionBarDrawerToggle(this, mDLayout, R.drawable.ic_menu, R.string.drawer_open, R.string.drawer_close){

			@Override
			public void onDrawerClosed(View drawerView) {
				getSupportActionBar().setTitle(title);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				getSupportActionBar().setTitle("Selecteaza o optiune");
				invalidateOptionsMenu();
			}
        	
        };
        mDLayout.setDrawerListener(drawerT);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.drawer_list_item,
        		getResources().getStringArray(R.array.optiuni));
        list.setAdapter(adapter);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				String[] optiuni = getResources().getStringArray(R.array.optiuni);
				title = optiuni[position];
				MenuFragment mFragment = new MenuFragment();
				Bundle data = new Bundle();
				data.putInt("position", position);
				//System.out.println(position + "!!!!!!!!!!!");
				mFragment.setArguments(data);
				android.app.FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.replace(R.id.content_frame, mFragment);
				ft.commit();
				mDLayout.closeDrawer(list);
			}
        	
		});
        
       
}
	
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerT.syncState();
	}


	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	public void harta(MenuItem v){
		Intent i = new Intent(this, MapActivity.class );
		startActivity(i);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerT.onOptionsItemSelected(item)){
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDLayout.isDrawerOpen(list);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}	
}