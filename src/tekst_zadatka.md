# Laboratorijske vežbe – dvočas br. 8

## Zadatak 1
*(radi laborant u saradnji sa studentima)*

Napraviti javnu apstraktnu klasu **Zaposleni** u paketu **zadatak1** koja ima:
1. Zaštićeni atribut **satnica** koji predstavlja vrednost jednog sata rada (realan broj).
2. Odgovarajuće javne **get i set metode** za atribut **satnica**.
3. Javnu apstraktnu metodu **izracunajPlatu** koja kao parametar prima broj radnih sati u mesecu i izračunava i vraća iznos plate.

Napraviti klasu **PogonskiRadnik** u paketu **zadatak1** koja nasleđuje klasu **Zaposleni** i:
1. Realizuje metodu **izracunajPlatu**. Ova metoda kao parametar prima broj radnih sati u mesecu i izračunava i vraća iznos plate pogonskog radnika prema sledećoj formuli: PLATA = BROJ SATI * SATNICA

Napraviti klasu **Komercijalista** u paketu **zadatak1** koja nasleđuje klasu **Zaposleni** i:
1. Realizuje metodu **izracunajPlatu**. Ova metoda kao parametar prima broj radnih sati u mesecu i izračunava i vraća iznos plate komercijaliste uzimajući u obzir i mesečni bonus od 50 000 dinara, a prema sledećoj formuli: PLATA = BROJ SATI * SATNICA + BONUS

Napraviti klasu **ProbaZaposleni** u paketu **zadatak1** koja kreira jednog pogonskog radnika sa satnicom od 170 dinara i jednog komercijalistu sa satnicom od 450 dinara. Izračunati i ispisati plate za oba radnika za mesec u kojem ima 176 radnih sati.

Napraviti interfejs **ObracunPlataInterfejs** u paketu **zadatak1.finansije** koji ima:
1. Javnu metodu **isplatiPlate** koja ne vraća ništa, a kao parametar prima niz objekata klase **Zaposleni** i broj radnih sati u mesecu.

Napraviti klasu **Racunovodstvo** u paketu **zadatak1.finansije** koja implementira interfejs **ObracunPlateInterfejs** i ima:
1. Privatni atribut **stanje** koje predstavlja ukupan iznos novca na računu kompanije (realan broj).
2. Odgovarajuće javne **get i set metode** za atribut **stanje**.
3. Implementiranu javnu metodu **isplatiPlate**. Ova metoda izračunava ukupnan trošak plata za sve zaposlene iz niza zaposlenih koji je prosleđen kao parametar. Ukoliko ima dovoljno novca na računu, za taj iznos se umanjuje stanje na računu. Ukoliko nema dovoljno novca, ispisati poruku "NEMA DOVOLJNO NOVCA".

U prethodno kreiranoj klasi **ProbaZaposleni** napraviti jedan objekat klase **Racunovodstvo** korišćenjem promenljive tipa **ObracunPlataInterfejs** i nad njim pozvati metodu **isplatiPlate** kojoj je prosleđen niz sa prethodno kreirana dva zaposlena i 176 kao broj radni sati.
 
Nakon toga, napraviti jednu promenljivu tipa **Racunovodstvo** i dodeliti joj već kreirani objekat klase **Racunovodstvo**. Dodati na stanje 1 000 000 dinara, a zatim ponovo pozivati metodu za isplatu plate (sa istim parametrima), ali preko nove reference. Na kraju, ispisati stanje na računu.

## Zadatak 2
*(studenti rade sami)*

Napraviti javni interfejs **AutomatNovcaInterfejs** u paketu **zadatak2** koji ima:
1. Javnu metodu **uloziNovac** koja ne vraća ništa, a kao parametar prima iznos koji se želi uneti (npr. 123,45 din).
2. Javnu metodu **podigniNovac** koja ne vraća ništa, a kao parametar prima iznos koji se želi podići (npr. 123,45 din).

Napraviti javnu klasu **Bankomat** u paketu **zadatak2** koja implementira interfejs **AutomatNovcaInterfejs** i ima:
1. Privatni atribut **stanje** koji predstavlja količinu novca koja se nalazi u automatu. Početno stanje je 5000.0 din.
2. Implementiranu metodu **uloziNovac**. Ova metoda vrši ulaganje tj. dodavanje unetog iznosa na trenutno stanje samo ako je uneti iznos veći od nule. U suprotnom, ispisuje se poruka "GRESKA".
3. Implementiranu metodu **podigniNovac**. Ova metoda vrši podizanje željenog iznosa tj. smanjivanje stanja samo ako je uneti iznos veći od nule i ako u automatu ima dovoljno novca. U suprotnom, ispisuje se poruka "GRESKA".
4. Javnu metodu **ispisiStanje** koja ispisuje koliko još novca ima u automatu.

Napraviti klasu **ProbaBankomat** u paketu **zadatak2** koja pravi objekat klase **Bankomat**, ali korišćenjem promenljive tipa **AutomatNovcaInterfejs** i poziva njegove metode. Napraviti jednu promenljivu tipa **Bankomat** i dodeliti joj već kreirani objekat klase **Bankomat**. Ponovo pozivati metode, ali preko nove reference.