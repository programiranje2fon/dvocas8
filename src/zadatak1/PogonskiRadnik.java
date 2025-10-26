package zadatak1;

public class PogonskiRadnik extends Zaposleni {

	@Override
	public double izracunajPlatu(int brojSati) {
		return brojSati * satnica;
	}

}
