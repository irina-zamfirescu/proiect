package teste;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import android.location.Location;
import android.test.InstrumentationTestCase;

import com.example.harta2.Attraction;

//@RunWith(MockitoJUnitRunner.class)
public class MockTest extends InstrumentationTestCase {
	Attraction atractie;
	Location loc;
	@Before
	public void setUp() throws Exception {
		atractie = new Attraction();
		loc = mock(Location.class);
		when(loc.getLatitude()).thenReturn((double) 19);
		when(loc.getLongitude()).thenReturn((double) 150);
		
	}
	
	@Test
	public void testCoordinates() {
		assertTrue(atractie.checkCoordinates());
	}

}
