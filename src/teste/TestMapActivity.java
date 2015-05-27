package teste;

import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.harta2.MapActivity;
import com.example.harta2.R;

import android.content.Context;
import android.location.Location;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;

public class TestMapActivity extends InstrumentationTestCase{
	BufferedReader bReader;
	InputStream file;
	int d;
	Location loc1, loc2;
	Location location1, location2;
	MapActivity dist;
	List<Location> locatii1, locatii2;
	List<Integer> distante;

	@Before
	protected void setUp() throws Exception {
		location1 = new Location(" ");
		location2 = new Location(" ");
		location1.setLatitude(45.1059);
		location1.setLongitude(24.3607);
		location2.setLatitude(44.439372);
		location2.setLongitude(25.982022);
		locatii1 = new ArrayList<Location>();
		locatii2 = new ArrayList<Location>();
		distante = new ArrayList<Integer>();
		try{
			dist = new MapActivity();
			Context context = getInstrumentation().getContext();	
			file = context.getResources().openRawResource(R.raw.coordonate);
			InputStreamReader iReader = new InputStreamReader(file);
			bReader = new BufferedReader(iReader);
			
			String linie = null;
			while ((linie=bReader.readLine()) != null && linie.length()!=0){
				float lat1 = Float.parseFloat(linie.split(" ")[0]);
				float lat2 = Float.parseFloat(linie.split(" ")[1]);
				float lat3 = Float.parseFloat(linie.split(" ")[2]);
				float lat4 = Float.parseFloat(linie.split(" ")[3]);
				d = Integer.parseInt(linie.split(" ")[4]);
				distante.add(d);
				loc1 = new Location("");
				loc2 = new Location("");
				loc1.setLatitude(lat1);
				loc1.setLongitude(lat2);
				locatii1.add(loc1);
				loc2.setLatitude(lat3);
				loc2.setLongitude(lat4);
				locatii2.add(loc2);
				
				System.out.println(lat1 + " " + lat2 + " " + lat3);
				System.out.println("d= " + d + " dist= " + dist.distanceBeetween(loc1, loc2));
				}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@After
	protected void tearDown() throws Exception {
		bReader.close();
		file.close();
	}


	@Test
	public void testDistanceBetweenTwoCoordinates() {
		int d = dist.distanceBeetween(location1, location2);
		assertEquals(148, d);
	}
	//Verifica daca datele din fisier sunt valide
	@Test
	public void testDistance() {
		for (int i=0; i<locatii1.size(); i++){
			assertEquals(distante.get(i), dist.distanceBeetween(locatii1.get(i), locatii2.get(i)));
		}
	}
	
	
}
