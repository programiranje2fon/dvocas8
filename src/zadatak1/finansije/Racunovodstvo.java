package zadatak1.finansije;

import zadatak1.Zaposleni;

public class Racunovodstvo implements ObracunPlataInterfejs {

	private double stanje;

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	@Override
	public void isplatiPlate(Zaposleni[] zaposleni, int brojSati) {
		double ukupanTrosakPlata = 0;
		
		for (Zaposleni z : zaposleni) {
			ukupanTrosakPlata += z.izracunajPlatu(brojSati);
		}
		
		if (ukupanTrosakPlata <= stanje) {
			stanje -= ukupanTrosakPlata;
		} else {
			System.out.println("NEMA DOVOLJNO NOVCA");
		}
	}

}
