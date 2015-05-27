package teste;

import static org.junit.Assert.*;
import com.example.harta2.*;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import android.test.InstrumentationTestCase;

import com.example.harta2.CitiesActivity;
import com.example.harta2.DataBaseHelper;

public class TestDataBaseHelper extends TestCase{
	DataBaseHelper myDbHelper = DataBaseHelper.getInstance();
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
