package teste;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestConstructors.class, 
				TestDataBaseHelper.class,
				TestGetAttributes.class, 
				TestSetAttributes.class,
				MockTest.class,
				TestMapActivity.class})
public class AllTests{

}
