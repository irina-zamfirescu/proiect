package teste;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import android.location.Location;

import com.example.harta2.Attraction;
import com.example.harta2.City;

public class TestGetAttributes extends TestCase{
	Attraction obiectiv;
	City city;
	Location location, location2;
	@Before
	protected void setUp() throws Exception {
		obiectiv = new Attraction();
		city = new City();
		location = new Location(" ");
		location2 = new Location(" ");
		location.setLatitude(45.67);
		location.setLongitude(25.89);
		
		location2.setLatitude(145.67);
		location2.setLongitude(225.89);
	}

	//--------------------Clasa Attraction--------------------
	//Testul1, metoda 1: Verifica daca paramatrul setat este acelasi cu cel returnat
	@Test
	public void testNameAttribute() throws Exception {
		obiectiv.setDenumire("Mamaia");
		assertEquals("Mamaia",obiectiv.getDenumire());
	}
	//Testul2, metoda 2
	@Test
	public void testDescriptionAttribute() throws Exception {
		obiectiv.setDescriere("O scurta descriere.");
		assertEquals("O scurta descriere.",obiectiv.getDescriere());
	}
	//Testul3, metoda 3
	@Test
	public void testLatAttribute() throws Exception {
		obiectiv.setLat((float) 45.67);
		assertEquals((float)45.67,obiectiv.getLat());
	}
	//Testul4, metoda 4
	@Test
	public void testLngAttribute() throws Exception {
		obiectiv.setLng((float) 45.67);
		assertEquals((float)45.67,obiectiv.getLng());
	}
	//Testul5, metoda 5
	@Test
	public void testVechimeAttribute() throws Exception {
		obiectiv.setVechime(100);
		assertEquals(100,obiectiv.getVechime());
	}
	//Testul6, metoda 6
	@Test
	public void testPopularAttribute() throws Exception {
		obiectiv.setPopular(0);
		assertEquals(0,obiectiv.getPopular());
	}	
	//----------------Clasa City--------------------------------
	//Testul7, metoda 7
	@Test
	public void testDescriptionAttributeForCity() throws Exception {
		city.setDescriere("Descriere scurta.");
		assertEquals("Descriere scurta.",city.getDescriere());
	}
	//Testul8, metoda 8
	@Test
	public void testNameAttributeForCity() throws Exception {
		city.setDenumire("Costinesti");
		assertEquals("Costinesti",city.getDenumire());
	}
	//Testul9, metoda 9
	@Test
	public void testCordinatesTrueForCity() throws Exception {
		obiectiv.setLoc(location);
		assertTrue(obiectiv.checkCoordinates());
	}
	//Testul10, metoda 10
	@Test
	public void testCordinatesFalseForCity() throws Exception {
		obiectiv.setLoc(location);
		assertTrue(obiectiv.checkCoordinates());
	}
}
