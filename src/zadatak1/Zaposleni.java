package zadatak1;

public abstract class Zaposleni {

	protected double satnica;

	public double getSatnica() {
		return satnica;
	}

	public void setSatnica(double satnica) {
		this.satnica = satnica;
	}

	public abstract double izracunajPlatu(int brojSati);
}
