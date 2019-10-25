package zadatak2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class BankomatTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private Bankomat instance;

	@Before
	public void setUp() throws Exception {
		instance = new Bankomat();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}
	
	@Test
	public void klasa_implementacijaInterfejsa() {
		assertTrue("Klasa Bankomat ne implementira interfejs AutomatNovcaInterfejs", AutomatNovcaInterfejs.class.isInstance(instance));
	}

	@Test
	public void atribut_stanje() {
		assertTrue("U klasi nije definisan atribut stanje", TestUtil.doesFieldExist(Bankomat.class, "stanje"));
	}
	
	@Test
	public void atribut_stanje_pocetnaVrednost() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "stanje");
		
		assertEquals("Atribut stanje nema pocetnu vrednost 5000", 5000, stanjeValue, 0.001);
	}
	
	@Test
	public void atribut_stanje_vidljivost() {
		assertTrue("Atribut stanje nije privatan", TestUtil.hasFieldModifier(Bankomat.class, "stanje", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_uloziNovac() {
		double stanjeValue1 = (double) TestUtil.getFieldValue(instance, "stanje");
		
		instance.uloziNovac(100);
		double stanjeValue2 = (double) TestUtil.getFieldValue(instance, "stanje");
		assertEquals("Nakon poziva metode uloziNovac(double) sa prosledjenim argumentom \"100\", vrednost atributa stanje se nije uvecalo za tu vrednost", 100, stanjeValue2 - stanjeValue1, 0.001);
	}
	
	@Test
	public void metoda_uloziNovac_manjeOd0() {
		instance.uloziNovac(-100);
		assertTrue("Nakon poziva metode uloziNovac(double) sa prosledjenim argumentom \"-100\", metoda nije ispisala tekst 'GRESKA'", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
	}
	
	@Test
	public void metoda_podigniNovac() {
		double stanjeValue1 = (double) TestUtil.getFieldValue(instance, "stanje");
		
		instance.podigniNovac(100);
		double stanjeValue2 = (double) TestUtil.getFieldValue(instance, "stanje");
		assertEquals("Nakon poziva metode podigniNovac(double) sa prosledjenim argumentom \"100\", vrednost atributa stanje se nije smanjila za tu vrednost", 100, stanjeValue1 - stanjeValue2, 0.001);
	}
	
	@Test
	public void metoda_podigniNovac_manjeOd0() {
		instance.podigniNovac(-100);
		assertTrue("Nakon poziva metode podigniNovac(double) sa prosledjenim argumentom \"-100\", metoda nije ispisala tekst 'GRESKA'", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
	}
	
	@Test
	public void metoda_podigniNovac_nemaDovoljnoNovca() {
		instance.podigniNovac(100000);
		assertTrue("Nakon poziva metode podigniNovac(double) sa prosledjenim argumentom \"100000\", a na stanju je \"5000\" dinara, metoda nije ispisala tekst 'GRESKA'", outContent.toString().toLowerCase().contains("GRESKA".toLowerCase()));
	}
}
