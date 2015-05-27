package teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import android.test.InstrumentationTestCase;

import com.example.harta2.Attraction;
import com.example.harta2.AttractionActivity;
import com.example.harta2.CitiesActivity;
import com.example.harta2.DataBaseHelper;
import com.example.harta2.MapActivity;
import com.example.harta2.MenuActivity;
import com.example.harta2.MenuFragment;
import com.example.harta2.City;

import junit.framework.TestCase;

public class TestConstructors extends TestCase {
	
	DataBaseHelper myDbHelper = DataBaseHelper.getInstance();
	Attraction attractionP;
	City city;
	@Before
	protected void setUp() throws Exception {
		attractionP = new Attraction();
		city = new City();
	}
	//-----------------------Clasa Attraction------------------------------------------------
	//Testul 1, metoda 1: Verifica daca se trimite ca paramatru in constructor un string null
	@Test
	public void testNullOnConstructorName(){		
		try {
			attractionP = new Attraction(null);
		} catch (Exception e) {
			assertEquals("Denumirea e null",e.getMessage());
		}	
	}
	//Testul 2, metoda 2
	@Test
	public void testOnConstructorPopular(){		
		try {
			attractionP = new Attraction(0);
		} catch (Exception e) {
			assertEquals("Incorect definita",e.getMessage());
		}	
	}
	//Testul 3, metoda 3: Verifica daca se trimite ca paramatru in constructorul cu parametrii un string null
	//pentru parametru denumire
	@Test
	public void testNullOnNameInConstructor(){		
		try {
			attractionP = new Attraction(null,"Nu e nimic aici",45,34,10,0);
		} catch (Exception e) {
			assertEquals("Denumirea e null",e.getMessage());
		}	
	}
	//Testul 4, metoda 3: Verifica daca se trimite ca paramatru in constructorul cu parametrii un string null
	//pentru parametrul descriere
	@Test
	public void testNullOnDescriptionInConstructor(){		
		try {
			attractionP = new Attraction("Ceva",null,(float)45.56,(float)34.56,10,0);
		} catch (Exception e) {
			assertEquals("Descrierea e null",e.getMessage());
		}	
	}
	//Testul 5, metoda 3
	@Test
	public void testNullOnLatInConstructor(){		
		try {
			attractionP = new Attraction("Ceva","Descriere",0,34,10,0);
		} catch (Exception e) {
			assertEquals("Incorect setat.",e.getMessage());
		}	
	}
	//Testul 6, metoda 3
	@Test
	public void testNullOnLngInConstructor(){		
		try {
			attractionP = new Attraction("Ceva","Descriere",(float)43.45,0,10,0);
		} catch (Exception e) {
			assertEquals("Incorect setat.",e.getMessage());
		}	
	}
	//Testul 7, metoda 3
	@Test
	public void testNullOnVechimeInConstructor(){		
		try {
			attractionP = new Attraction("Ceva","Descriere",(float)43.45,(float)43.67,0,0);
		} catch (Exception e) {
			assertEquals("Incorect setat.",e.getMessage());
		}	
	}
	//Testul 8, metoda 3
	@Test
	public void testNullOnPopularInConstructor(){		
		try {
			attractionP = new Attraction("Ceva","Descriere",(float)43.45,(float)43.67,100,2);
		} catch (Exception e) {
			assertEquals("Incorect setat.",e.getMessage());
		}	
	}
	//--------------------Clasa City-------------------------------------------
	//Testul 9, metoda 3
	@Test
	public void testNullOnDescriptionInCityConstructor(){		
		try {
			city = new City("Ceva",null);
		} catch (Exception e) {
			assertEquals("Descrierea e null",e.getMessage());
		}	
	}
	//Testul 10, metoda 3
	@Test
	public void testNullOnNameInCityConstructor(){		
		try {
			city = new City(null,"Descriere");
		} catch (Exception e) {
			assertEquals("Denumirea e null",e.getMessage());
		}	
	}
}
