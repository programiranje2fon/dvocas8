package zadatak2;

public class Bankomat implements AutomatNovcaInterfejs {

	private double stanje = 5000;

	public void uloziNovac(double iznos) {
		if (iznos <= 0) {
			System.out.println("GRESKA");
		} else {
			stanje = stanje + iznos;
		}
	}

	public void podigniNovac(double iznos) {
		if (iznos <= 0) {
			System.out.println("GRESKA");
		} else {
			if (stanje >= iznos) {
				stanje = stanje - iznos;
			} else {
				System.out.println("Zao nam je, nema dovoljno novca");
			}
		}
	}

	public void ispisiStanje() {
		System.out.println("U bankomatu trenutno ima: " + stanje + " dinara");
	}

}
