package Auditoriski.Prvi.Intro;

import java.util.Scanner;

public class Kompanija {
    private Vraboten[] vraboteni;

    public Kompanija(Vraboten[] vraboteni) {
        this.vraboteni = vraboteni;
    }

    public Vraboten najangaziran() {
        int max = 0, k = 0;
        for (int i = 0; i < vraboteni.length; i++) {
            if (vraboteni[i].vkupno() > max) {
                max = vraboteni[i].vkupno();
                k = i;
            }
        }
        return vraboteni[k];
    }

    public void pecatiPoUspeh() {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < vraboteni.length; j++) {
                if (vraboteni[j].vkupno() < vraboteni[j + 1].vkupno()) {
                    Vraboten tmp = vraboteni[j];
                    vraboteni[j] = vraboteni[j + 1];
                    vraboteni[j + 1] = tmp;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < vraboteni.length; i++) {
            System.out.printf("Vraboten: " + vraboteni[i].getIme() + " " +
                            vraboteni[i].getPrezime() + " " + "Uspesnost: %.2f\n",
                    (vraboteni[i].vkupno() * 100)
            );
        }

    }

    public void pecati() {
        for (Vraboten v : vraboteni) {
            System.out.println(v.toString());
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Vraboten[] pom = new Vraboten[n];
        for (int i = 0; i < n; i++) {
            Vraboten v = new Vraboten();
            v.setIme(input.next());
            v.setPrezime(input.next());
            v.setStaz(input.nextInt());
            v.setBrBod(input.nextInt());
            pom[i] = v;

            int p = input.nextInt();
            for (int j = 0; j < p; j++) {
                Zadaca z = new Zadaca();
                z.setCasovi(input.nextInt());
                z.setOpis(input.next());
                z.setStatus(input.nextBoolean());
                v.dodadiZadaca(z);
            }
        }
        Kompanija k = new Kompanija(pom);
        k.pecati();
        k.pecatiPoUspeh();
        System.out.println("Najangaziran: " + k.najangaziran());
    }
}
