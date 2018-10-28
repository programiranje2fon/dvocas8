package zadatak1;

import zadatak1.finansije.ObracunPlataInterfejs;
import zadatak1.finansije.Racunovodstvo;

public class ProbaZaposleni {

	public static void main(String[] args) {
		PogonskiRadnik radnik1 = new PogonskiRadnik();
		radnik1.setSatnica(170);
		System.out.println(radnik1.izracunajPlatu(176));
		
		Komercijalista radnik2 = new Komercijalista();
		radnik2.setSatnica(450);
		System.out.println(radnik2.izracunajPlatu(176));
		
		ObracunPlataInterfejs obracunPlata = new Racunovodstvo();
		obracunPlata.isplatiPlate(new Zaposleni[]{radnik1, radnik2}, 176);
		
		Racunovodstvo racunovodstvo = (Racunovodstvo) obracunPlata;
		racunovodstvo.setStanje(1000000);

		racunovodstvo.isplatiPlate(new Zaposleni[]{radnik1, radnik2}, 176);
		System.out.println("Stanje je: " + racunovodstvo.getStanje());
	}

}
