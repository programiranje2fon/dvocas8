package zadatak1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KomercijalistaTest {

	private Komercijalista instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Komercijalista();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void klasa_nasledjivanje() {
		assertTrue("Klasa Komercijalista ne nasledjuje klasu Zaposleni", Zaposleni.class.isInstance(instance));
	}
	
	@Test
	public void metoda_izracunajPlatu() {
		instance.setSatnica(100);
		assertEquals("Za satnicu od 100 dinara i broj sati 10, metoda izracunajPlatu(int) ne vraca vrednost 51000", 51000, instance.izracunajPlatu(10), 0.001);
	}
}
