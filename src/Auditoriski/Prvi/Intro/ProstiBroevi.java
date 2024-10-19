package Auditoriski.Prvi.Intro;

import java.util.Scanner;

public class ProstiBroevi {

    public static void main(String[] args) {
        long suma = 0;
        //int lim=100;
        Scanner s = new Scanner(System.in);
        int lim = s.nextInt();
        for (int i = 1; i <= lim; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                suma += i;
            }
        }
        System.out.println(suma);
    }
}
