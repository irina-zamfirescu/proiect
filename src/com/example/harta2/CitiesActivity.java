package com.example.harta2;

import interfete.TableActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CitiesActivity extends ActionBarActivity implements TableActivity{

	DataBaseHelper myDbHelper;
	List<City> orase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cities);
//open database
		

		try {
			orase = makeListOrase();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		populateList();
	}
	public List<City> makeListOrase() throws Exception, Error{
		orase = new ArrayList<City>();
		myDbHelper = DataBaseHelper.getInstance();
		try {
			myDbHelper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			myDbHelper.openDataBase();
		} catch (Exception e) {
			System.out.println("Nu se poate deschide BD!");
		}
		
		
		
		
		Cursor curs = myDbHelper.getDb().rawQuery("SELECT * FROM orase", null);
		
		if (curs != null) {
			curs.moveToFirst();
			do {
				String den = curs.getString(curs.getColumnIndex("denumire"));
				City o = new City(den);
				orase.add(o);
				System.out.println("Linie: " + den);
			} while (curs.moveToNext());
		}
		curs.close();
		return orase;
	}
	
	private class MyAdapter extends ArrayAdapter<City> {

		public MyAdapter() {
			super(CitiesActivity.this, R.id.cities_list,orase);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View item = convertView;
			if (item == null) {
				item = getLayoutInflater().inflate(
						R.layout.item_list, parent, false);
			}

			City city = orase.get(position);
			TextView text = (TextView) item.findViewById(R.id.denumire);
			text.setText(city.getDenumire());
			
			//TextView text2 = (TextView) item.findViewById(R.id.desc);
			//text2.setText(oras.getDescriere());	
			return item;
		}

	}



	@Override
	public void populateList() {
		ArrayAdapter<City> adapter = new MyAdapter();
		ListView list = (ListView) findViewById(R.id.cities_list);
		list.setAdapter(adapter);
	}
}
