package com.example.harta2;
import java.io.File;
import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends ActionBarActivity implements
		OnMarkerClickListener {

	DataBaseHelper myDbHelper;
	Marker marker;
	private GoogleMap googleMap;
	Cursor c;
	final int RQS_GooglePlayServices = 1;
	private static final LatLng nord = new LatLng(47.6728, 24.0050);
	private static final LatLng sud = new LatLng(44.3333, 23.8167);
	private static final LatLng vest = new LatLng(45.7597, 21.2300);
	private static final LatLng est = new LatLng(45.4233, 28.0425);
	float[] results;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		results = null;
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// creez helper ce cloneaza baza de date din assets---------------------------------------------------------
		//singletone
		myDbHelper = DataBaseHelper.getInstance();
		try {
			myDbHelper.createDataBase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDbHelper.openDataBase();
		// -----------------------------------------------------------------

		try {
			//Facade--------------------------------------------------------
			rutineMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 //googleMap = null;
	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	public void rutineMap(){
		googleMap = initilizeMap();
		setLimits();
		addMarkerForCities();
		addMarkerForAttractions();
		checkMap();		
	}
	public GoogleMap initilizeMap() {
		//if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();
			return googleMap;
		
	}
	public void checkMap(){
			if (googleMap != null) {
				googleMap.setInfoWindowAdapter(new InfoWindowAdapter() {

					@Override
					public View getInfoWindow(Marker arg0) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public View getInfoContents(Marker marker) {
						String den = null, desc = null;
						float lat = 0, lng = 0;
						String titlu = marker.getTitle();
						Cursor curs = myDbHelper.getDb().rawQuery(
								"SELECT * FROM orase where denumire='" + titlu
										+ "'", null);
						if (curs != null) {
							if (curs.moveToFirst()) {
								den = curs.getString(curs
										.getColumnIndex("denumire"));
								desc = curs.getString(curs
										.getColumnIndex("descriere"));
								lat = curs.getFloat(curs.getColumnIndex("lat"));
								lng = curs.getFloat(curs.getColumnIndex("lng"));
								System.out.println("Linie: " + den + " ["
										+ desc + "]" + lat + " " + lng);
								// Location.distanceBetween(47.6728, 24.0050,
								// 44.3333, 23.8167, results);
								// System.out.println("---Distanta dintre nord si sud este: "
								// + results[0]);

							}
						}
						curs.close();
						View v = getLayoutInflater().inflate(
								R.layout.info_window, null);
						TextView n = (TextView) v.findViewById(R.id.text1);
						TextView d = (TextView) v.findViewById(R.id.text2);
						TextView m = (TextView) v.findViewById(R.id.text3);
						n.setText(den);
						d.setText(desc);
						m.setText(lat + " " + lng);
						return v;
					}
				});
			}
			}

			// check if map is created successfully or not
//			if (googleMap == null) {
//				Toast.makeText(getApplicationContext(),
//						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
//						.show();
//			}
		//}
		

		// add marker for each city ******************************
		public void addMarkerForCities(){
		c = myDbHelper.getDb().rawQuery("SELECT * FROM orase", null);
		c.moveToFirst();
		do {
			String den = c.getString(c.getColumnIndex("denumire"));
			String desc = c.getString(c.getColumnIndex("descriere"));
			Float lat = c.getFloat(c.getColumnIndex("lat"));
			Float lng = c.getFloat(c.getColumnIndex("lng"));
			System.out.println("Linie: " + den + " [" + desc + "]" + lat + " " + lng);
			addMarkerOnMap(lat,lng,0,den);

		} while (c.moveToNext());
		c.close();
		}
		// ****************************************************
		// add marker for each atraction-----------------------------
		public void addMarkerForAttractions(){
		c = myDbHelper.getDb().rawQuery("SELECT * FROM obiective_turistice",
				null);
		c.moveToFirst();
		do {
			String den = c.getString(c.getColumnIndex("denumire"));
			String desc = c.getString(c.getColumnIndex("descriere"));
			Float lat = c.getFloat(c.getColumnIndex("lat"));
			Float lng = c.getFloat(c.getColumnIndex("lng"));
			int id = c.getInt(c.getColumnIndex("id_categorie"));
			System.out.println("Linie: " + den + " [" + desc + "]" + lat + " "
					+ lng);
			addMarkerOnMap(lat,lng,id,den);
		} while (c.moveToNext());

		
		c.close();
		}
		// -----------------------------------------------------------
		// butoanele + si - de zoom in si zoom put
		public void setLimits(){
		googleMap.getUiSettings().setZoomControlsEnabled(true);
		// Get a map (frontiere)--------------------------------------
		final View mapView = getFragmentManager().findFragmentById(R.id.map)
				.getView();
		if (mapView.getViewTreeObserver().isAlive()) {
			mapView.getViewTreeObserver().addOnGlobalLayoutListener(
					new OnGlobalLayoutListener() {
						@SuppressWarnings("deprecation")
						@SuppressLint("NewApi")
						// We check which build version we are using.
						@Override
						public void onGlobalLayout() {
							LatLngBounds bounds = new LatLngBounds.Builder()
									.include(vest).include(est).include(nord)
									.include(sud).build();

							if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
								mapView.getViewTreeObserver()
										.removeOnGlobalLayoutListener(this);
							} else {
								mapView.getViewTreeObserver()
										.removeOnGlobalLayoutListener(this);
							}
							googleMap.moveCamera(CameraUpdateFactory
									.newLatLngBounds(bounds, 50));
						}
					});
		}
		}
	//}
	
	public void addMarkerOnMap(Float lat, Float lng, int id, String den){
		if (id == 0) {
			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lng))
					.title(den)
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.flag_128)));
		}
		if (id == 1) {
			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lng))
					.title(den)
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.castle2)));
		}
		if (id == 2) {
			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lng))
					.title(den)
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.anchor)));
		}
		if (id == 3) {
			googleMap.addMarker(new MarkerOptions()
					.position(new LatLng(lat, lng))
					.title(den)
					.icon(BitmapDescriptorFactory
							.fromResource(R.drawable.church)));
		}
	}
	
	
//	Location loc1, Location loc2
	public Integer distanceBeetween(Location loc1, Location loc2){
		float distanceInMeters = loc1.distanceTo(loc2);
		System.out.println("!!!Distanta este: " + distanceInMeters / 1000);
		return (int) (distanceInMeters/1000);
	}
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		if (this.marker == marker) {
			AlertDialog aler = new AlertDialog.Builder(getBaseContext())
					.create();
			aler.show();
		}

		return false;
	}

}
