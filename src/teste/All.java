package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import android.location.Location;

import com.example.harta2.Attraction;
import com.example.harta2.City;
import com.example.harta2.DataBaseHelper;

public class All {

	DataBaseHelper myDbHelper;
	Attraction attraction;
	Attraction obiectiv;
	Attraction attractionP;
	City city;
	Location location, location2;
	
	@Before
	protected void setUp() throws Exception {
		attraction = new Attraction();
		attractionP = new Attraction();
		obiectiv = new Attraction();
		city = new City();
		myDbHelper = DataBaseHelper.getInstance();
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
	//------------------------------------get-------------------------------------------------------------
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
		//---------------------constructors---------------------------------------------------
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
		//---------------------------------------------------------------------------
		//Testul1, metoda 1: Verific daca am folosit Singletone corect; daca cele doua obiecte refera acelasi obiect
		@Test
		public void testDB(){
			DataBaseHelper db = DataBaseHelper.getInstance();
			assertSame(myDbHelper.getDb(),db.getDb());
		}
		////Testul2, metoda 2: Verifica daca baza de date exista. Daca exista o inchide
		@Test
		public void testcheckDB() throws Exception{
			DataBaseHelper db = DataBaseHelper.getInstance();
			assertTrue(db.checkDataBase());	
		}
		////Testul3, metoda 3: Verifica daca baza de date s-a deschis
		@Test
		public void testDBIsOpen(){
			DataBaseHelper db = DataBaseHelper.getInstance();
			assertTrue(db.openDataBaseVerify());
		}

}
