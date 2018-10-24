package zadatak1.finansije;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.TestUtil;
import zadatak1.Zaposleni;

public class ObracunPlataInterfejsTest {

	@Test
	public void metoda_isplatiPlate() {
		assertTrue("U klasi nije definisana metoda isplatiPlate(Zaposleni[], int)", TestUtil.doesMethodExist(ObracunPlataInterfejs.class, "isplatiPlate", new Class<?>[]{Zaposleni[].class, int.class}));
	}
	
}
