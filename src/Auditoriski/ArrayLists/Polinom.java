package Auditoriski.ArrayLists;

public class Polinom {
    Array<Integer> koeficienti;

    public Polinom(Array<Integer> koeficienti) {
        this.koeficienti = koeficienti;
    }

    public Array<Integer> getKoeficienti() {
        return koeficienti;
    }

    public void setKoeficienti(Array<Integer> koeficienti) {
        this.koeficienti = koeficienti;
    }

    @Override
    public String toString() {
        String returnString = new String();
        for (int i = 1; i <= koeficienti.get(0) * 2; i *= 2) {
            returnString += koeficienti.get(i + 1) + "*x^" + koeficienti.get(i) + " ";
        }
        return returnString;
    }

    public Polinom soberiPolinom(Polinom p) {
        Array<Integer> koeficienti2 = p.getKoeficienti();
        int n = this.koeficienti.get(0);
        int m = koeficienti2.get(0);

        Array<Integer> rezultat = new Array<Integer>(n * 2 + m * 2 + 1);
        int i = 1, j = 1, k = 1;
        while (i <= 2 * n && j <= 2 * m) {
            if (koeficienti.get(i).equals(koeficienti2.get(j))) {
                rezultat.set(k + 1, koeficienti.get(i + 1) + koeficienti2.get(j + 1));

                if (rezultat.get(k + 1) != null) {
                    rezultat.set(k, koeficienti.get(i));
                    k += 2;
                }
                i += 2;
                j += 2;
            } else {
                if (koeficienti.get(i) < koeficienti2.get(j)) {
                    rezultat.set(k + 1, koeficienti2.get(j + 1));
                    rezultat.set(k, koeficienti2.get(j));

                    k += 2;
                    j += 2;
                } else if (koeficienti.get(i) > koeficienti2.get(j)) {
                    rezultat.set(k + 1, koeficienti.get(i + 1));
                    rezultat.set(k, koeficienti.get(i));

                    k += 2;
                    i += 2;
                }
            }
        }

        while (i <= 2 * n) {
            rezultat.set(k + 1, koeficienti.get(i + 1));
            rezultat.set(k, koeficienti.get(i));

            k += 2;
            i += 2;
        }
        while (j <= 2 * n) {
            rezultat.set(k + 1, koeficienti.get(j + 1));
            rezultat.set(k, koeficienti.get(j));

            k += 2;
            j += 2;
        }

        rezultat.set(0, k / 2);
        return new Polinom(rezultat);
    }
}
