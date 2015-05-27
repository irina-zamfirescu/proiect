package com.example.harta2;

import interfete.TableActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import android.app.ActionBar;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AttractionActivity extends ActionBarActivity implements TableActivity{

	DataBaseHelper myDbHelper;
	List<Attraction> attractions;
	ListView list;
	ArrayAdapter<String> typeAdapter;
	List<String> listaObiective;
	AutoCompleteTextView obiectiv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attractions);

		attractions = new ArrayList<Attraction>();

		myDbHelper = DataBaseHelper.getInstance();
		
			try {
				myDbHelper.createDataBase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			myDbHelper.openDataBase();
		} catch (Exception e) {
			System.out.println("Nu se poate deschide BD!");
		}

		//autocomplete pentru categoria obiectivului turistic
		
		listaObiective= new ArrayList<String>();
		obiectiv = (AutoCompleteTextView) findViewById(R.id.obiectiv);
		Cursor curs = myDbHelper.getDb().rawQuery("SELECT * FROM categorie", null);
		if (curs != null) {
			curs.moveToFirst();
			do {
				String categ = curs.getString(curs.getColumnIndex("categorie"));
				listaObiective.add(categ);
				System.out.println("Linie: " + categ);
			} while (curs.moveToNext());
		}
		curs.close();
		
		 typeAdapter = new ArrayAdapter<String>(AttractionActivity.this,
				 								android.R.layout.simple_dropdown_item_1line,
				 								listaObiective);
		 obiectiv.setAdapter(typeAdapter);
		 obiectiv.setThreshold(1);
	}

	
	private class MyAdapter extends ArrayAdapter<Attraction> {

		public MyAdapter() {
			super(AttractionActivity.this, R.id.cities_list,attractions);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View item = convertView;
			if (item == null) {
				item = getLayoutInflater().inflate(
						R.layout.item_list, parent, false);
			}

			Attraction attraction = attractions.get(position);
			TextView text = (TextView) item.findViewById(R.id.denumire);
			text.setText(attraction.getDenumire());
			return item;
		}

	}
	public void cauta(View v) throws Exception{
		attractions.clear();
//		obiectiv = (AutoCompleteTextView) findViewById(R.id.obiectiv);
		String ob = obiectiv.getText().toString();
		System.out.println(ob + "!!!!!!!!!");
		Cursor curs = myDbHelper.getDb().rawQuery("SELECT * FROM obiective_turistice where id_categorie=(select _id from categorie where categorie = '" +ob+"')", null);
		if (curs != null) {
			curs.moveToFirst();
			
			do {
				String den = curs.getString(curs.getColumnIndex("denumire"));
				String desc = curs.getString(curs.getColumnIndex("descriere"));
				
//Builder----------------------------------------------------------------------------------
				Attraction o = new AttractionBuilder().setDenumire(den).setDescriere(desc).build();
				attractions.add(o);
				System.out.println("Linie: " + den);
			} while (curs.moveToNext());
		}
		
		curs.close();
		obiectiv.getText().clear();
		populateList();
		
	}
	@Override
	public void populateList() {
		ArrayAdapter<Attraction> adapter = new MyAdapter();
		list = (ListView) findViewById(R.id.attraction_list);
		list.setAdapter(adapter);
		
	}

}
