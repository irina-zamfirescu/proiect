package com.example.harta2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MenuFragment extends Fragment {

	View v;
	DataBaseHelper myDbHelper;
	List<City> orase;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		int pos = getArguments().getInt("position");
		String[] optiuni = getResources().getStringArray(R.array.optiuni);

		if (pos == 2) {
			Intent i = new Intent(MenuFragment.this.getActivity(),
					MakeListActivity.class);
			startActivity(i);
		}
		if (pos == 1) {
			Intent i = new Intent(MenuFragment.this.getActivity(),
					TutorialActivity.class);
			startActivity(i);
		}
		if (pos == 0) {
			Intent i = new Intent(MenuFragment.this.getActivity(), MapActivity.class);
			startActivity(i);
		}
		if (pos == 3){
		 Intent i = new Intent(MenuFragment.this.getActivity(),AttractionActivity.class );
		 startActivity(i);
		 }
		if (pos == 4) {
			Intent i = new Intent(MenuFragment.this.getActivity(), CitiesActivity.class);
			startActivity(i);
		}
		//((ActionBarActivity) getActivity()).getSupportActionBar().setTitle(optiuni[pos]);
		return v;
	}
}
