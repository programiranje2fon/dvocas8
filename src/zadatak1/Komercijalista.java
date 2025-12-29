package zadatak1;

public class Komercijalista extends Zaposleni {

    @Override
    public double izracunajPlatu(int brojSati) {
        return brojSati * satnica + 50000;
    }

}
