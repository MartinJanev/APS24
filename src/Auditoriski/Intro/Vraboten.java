package Auditoriski.Prvi.Intro;

public class Vraboten {
    private static double BOD = 50;
    private String ime;
    private String prezime;
    private double plata;
    private int staz;
    private int brBod;
    private Zadaca[] zadaci;
    private int brZadaci;

    public Vraboten() {
        zadaci = new Zadaca[10];
        brZadaci = 0;
    }

    public Vraboten(String ime, String prezime, double plata, int staz, int brBod) {
        super();
        this.ime = ime;
        this.prezime = prezime;
        this.staz = staz;
        this.brBod = brBod;
        this.plata = brBod * BOD;
    }

    public int getBrZadaci() {
        return brZadaci;
    }

    public void setBrZadaci(int brZadaci) {
        this.brZadaci = brZadaci;
    }

    public Zadaca[] getZadaci() {
        return zadaci;
    }

    public void setZadaci(Zadaca[] zadaci) {
        this.zadaci = zadaci;
    }

    public int getBrBod() {
        return brBod;
    }

    public void setBrBod(int brBod) {
        this.brBod = brBod;
    }

    public int getStaz() {
        return staz;
    }

    public void setStaz(int staz) {
        this.staz = staz;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public void dodadiZadaca(Zadaca z) {
        if (brZadaci == 10) {
            System.out.println("Ne moze da se dodade zadaca");
        } else {
            zadaci[brZadaci++] = z;
        }
    }

    public int vkupno() {
        int sum = 0;
        for (int i = 0; i < brZadaci; i++) {
            sum += zadaci[i].getCasovi();
        }
        return sum;
    }
}
