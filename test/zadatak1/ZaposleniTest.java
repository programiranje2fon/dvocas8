package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class ZaposleniTest {

	private Zaposleni instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Zaposleni() {
			@Override
			public double izracunajPlatu(int brojSati) {
				return 0;
			}
		};
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_slobodno() {
		assertTrue("U klasi nije definisan atribut satnica", TestUtil.doesFieldExist(Zaposleni.class, "satnica"));
	}
	
	@Test
	public void atribut_slobodno_vidljivost() {
		assertTrue("Atribut satnica nije zasticen (protected)", TestUtil.hasFieldModifier(Zaposleni.class, "satnica", Modifier.PROTECTED));
	}
	
	@Test
	public void metoda_setSatnica() {
		instance.setSatnica(10);
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "satnica");
		assertEquals("Nakon poziva metode setSatnica(double) sa prosledjenim argumentom \"10\", vrednost atributa satnica nema tu vrednost", 10, satnicaValue, 0.001);
	}
	
	@Test
	public void metoda_getSatnica() {
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "satnica");

		assertEquals("Metoda getSatnica() ne vraca vrednost atributa satnica", satnicaValue, instance.getSatnica(), 0.001);
	}
	
	@Test
	public void metoda_izracunajPlatu() {
		assertTrue("U klasi nije definisana metoda izracunajPlatu(int)", TestUtil.doesMethodExist(Zaposleni.class, "izracunajPlatu", new Class<?>[]{int.class}));
	}
}
