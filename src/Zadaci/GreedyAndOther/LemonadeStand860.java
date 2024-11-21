package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class LemonadeStand860 {
    /*
    smetki [5,5,5,10,20]
    pet = 1,2,3,2,1
    deset = 1,0
    dvaeset = 1.

     smetki [5,5,10,10,20]
    pet = 1,2,1,0,-1 - pagja kaj posledniot
    deset = 1,2,1
    dvaeset = 1


    ako dade 5 dolari : 0 kusur
    ako dade 10 dolari: 5 kusur
    ako dade 20 dolari: 3x5kusur ILI 10 + 5 kusur
     */

    public static boolean lemonadeCahnge(int[] bills) {
        int petki = 0, desetki = 0;
        for (int bill : bills) {
            if (bill == 5) {
                petki++;
            }
            if (bill == 10) {
                if (petki == 0) {
                    return false;
                }
                petki--;
                desetki++;
            }
            if (bill == 20) {
                if (desetki > 0 && petki > 0) {
                    desetki--;
                    petki--;
                } else if (petki >= 3) {
                    petki -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            bills[i] = sc.nextInt();
        }

        System.out.println(lemonadeCahnge(bills));
    }
}
