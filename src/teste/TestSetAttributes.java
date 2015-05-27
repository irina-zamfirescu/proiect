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

public class TestSetAttributes extends TestCase{
	Attraction attraction;
	City city;
	Location location, location2;
	
	@Before
	protected void setUp() throws Exception {
		attraction = new Attraction();
		city = new City();
		location = new Location(" ");
		location2 = new Location(" ");
		location.setLatitude(45.67);
		location.setLongitude(25.89);
		
		location2.setLatitude(145.67);
		location2.setLongitude(225.89);
	}
	//--------------------Clasa Attraction-----------------------------------
	//Testul1, metoda 1
	@Test
	public void testLatSetterAtribute() {
		try{
			attraction.setLat(0);
		}
		catch(Exception ex){
			assertEquals("Incorect setat", ex.getMessage());
		}
	}
	//Testul2, metoda 2
	@Test
	public void testLngSetterAtribute() {
		try{
			attraction.setLng(0);
		}
		catch(Exception ex){
			assertEquals("Incorect setat", ex.getMessage());
		}
	}
	//Testul3, metoda 3
	@Test
	public void testDescriptionSetterAtribute() {
		try{
			attraction.setDescriere(null);
		}
		catch(Exception ex){
			assertEquals("Descriere vida", ex.getMessage());
		}
	}
	//Testul4, metoda 4
	@Test
	public void testVechimeSetterAtribute() {
		try{
			attraction.setVechime(0);
		}
		catch(Exception ex){
			assertEquals("Incorect setat", ex.getMessage());
		}
	}
	//Testul5, metoda 5
	@Test
	public void testPopularSetterAtribute() {
		try{
			attraction.setPopular(0);
		}
		catch(Exception ex){
			assertEquals("Incorect setat", ex.getMessage());
		}
	}
	//Testul 6, metoda 6: Verifica daca valoarea setata pentru atributul denumire este null sau nimic
	@Test
	public void testNameSetterAttribute() throws Exception {
		try{
			attraction.setDenumire(null);
		}
		catch(Exception ex){
			assertEquals("Null sau Nimic", ex.getMessage());
		}
	}
	//Testul 7, metoda 7
	@Test
	public void testLocationSetterAttribute() throws Exception {
		try{
			attraction.setLoc(location2);
		}
		catch(Exception ex){
			assertEquals("Coordonate setate incorect", ex.getMessage());
		}
	}
	//-------------------------Clasa City------------------------------------------------
	//Testul8, metoda 8
	@Test
	public void testDescriptionFromCitySetterAtribute() {
		try{
			city.setDescriere(null);
		}
		catch(Exception ex){
			assertEquals("Descriere vida", ex.getMessage());
		}
	}
	//Testul9, metoda 9
	public void testNameFromCitySetterAtribute() {
		try{
			city.setDenumire(null);
		}
		catch(Exception ex){
			assertEquals("Null sau Nimic", ex.getMessage());
		}
	}
}
