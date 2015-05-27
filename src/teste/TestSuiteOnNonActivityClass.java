package teste;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestConstructors.class, TestDataBaseHelper.class})
public class TestSuiteOnNonActivityClass {
	
	public static Test suite(){
		TestSuite suiteTeste = new TestSuite();
		TestConstructors t1 = new TestConstructors();
		t1.setName("testNullOnNameInConstructor");
		suiteTeste.addTest(t1);
		
		t1 = new TestConstructors();
		t1.setName("testNullOnConstructorName");
		suiteTeste.addTest(t1);
		
		TestDataBaseHelper t3 = new TestDataBaseHelper();
		t3 = new TestDataBaseHelper();
		t3.setName("testDB");
		suiteTeste.addTest(t3);
		return suiteTeste;
	}

}
