package zadatak1.finansije;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;
import zadatak1.Komercijalista;
import zadatak1.PogonskiRadnik;
import zadatak1.Zaposleni;

public class RacunovodstvoTest {

	private Racunovodstvo instance;

	@Before
	public void setUp() throws Exception {
		instance = new Racunovodstvo();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void klasa_implementacijaInterfejsa() {
		assertTrue("Klasa Racunovodstvo ne implementira interfejs ObracunPlataInterfejs", ObracunPlataInterfejs.class.isInstance(instance));
	}

	@Test
	public void atribut_stanje() {
		assertTrue("U klasi nije definisan atribut stanje", TestUtil.doesFieldExist(Racunovodstvo.class, "stanje"));
	}
	
	@Test
	public void atribut_stanje_vidljivost() {
		assertTrue("Atribut stanje nije privatan", TestUtil.hasFieldModifier(Racunovodstvo.class, "stanje", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setStanje() {
		instance.setStanje(100);
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "stanje");
		assertEquals("Nakon poziva metode setStanje(double) sa prosledjenim argumentom \"100\", vrednost atributa stanje nema tu vrednost", 100, stanjeValue, 0.001);
	}
	
	@Test
	public void metoda_getStanje() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "stanje");

		assertEquals("Metoda getStanje() ne vraca vrednost atributa stanje", stanjeValue, instance.getStanje(), 0.001);
	}
	
	@Test
	public void metoda_isplatiPlate() {
		PogonskiRadnik pr1 = new PogonskiRadnik();
		pr1.setSatnica(100);
		
		PogonskiRadnik pr2 = new PogonskiRadnik();
		pr2.setSatnica(150);
		
		Komercijalista k1 = new Komercijalista();
		k1.setSatnica(200);
		
		instance.setStanje(200000);
		instance.isplatiPlate(new Zaposleni[]{pr1, pr2, k1}, 160);
		
		assertEquals("Za prosledjene niz sa tri zaposlena (PogonskiRadnik satnica 100 din., PogonskiRadnik satnica 150 din. i Komercijalista satnica 200 din.) i broj radnik sati 160, metoda isplatiPlate() u momentu kada je stanje 100000 dinara, nije umanjilo stanje na 78000.0 dinara.", 78000, instance.getStanje(), 0.001);
	}

}
