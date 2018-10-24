package zadatak2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.TestUtil;

public class AutomatNovcaInterfejsTest {
	
	@Test
	public void metoda_uloziNovac() {
		assertTrue("U klasi nije definisana metoda uloziNovac(double)", TestUtil.doesMethodExist(AutomatNovcaInterfejs.class, "uloziNovac", new Class<?>[]{double.class}));
	}

	@Test
	public void metoda_podigniNovac() {
		assertTrue("U klasi nije definisana metoda podigniNovac(double)", TestUtil.doesMethodExist(AutomatNovcaInterfejs.class, "podigniNovac", new Class<?>[]{double.class}));
	}
}
