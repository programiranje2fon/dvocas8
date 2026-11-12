package zadatak2;

public class ProbaBankomat {
    public static void main(String[] args) {
        AutomatNovcaInterfejs a = new Bankomat();

        a.uloziNovac(430);
        a.podigniNovac(222.34);

        Bankomat an = (Bankomat) (a);
        an.uloziNovac(500);
        an.ispisiStanje();
    }
}
