package Auditoriski.Prvi.Intro;

public class Zadaca {
    private String opis;
    private int casovi;
    private boolean status;

    public Zadaca(String opis, int casovi, boolean status) {
        super();
        this.opis = opis;
        this.casovi = casovi;
        this.status = status;
    }

    public Zadaca() {
    }

    @Override
    public String toString() {
        return "opis=" + opis + ", casovi=" + casovi + ", status=" +
                (status ?"aktivna":"zavrsena");
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCasovi() {
        return casovi;
    }

    public void setCasovi(int casovi) {
        this.casovi = casovi;
    }
}
