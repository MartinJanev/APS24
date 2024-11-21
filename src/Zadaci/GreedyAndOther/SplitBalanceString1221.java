package Zadaci.GreedyAndOther;

        /*
        RLRRLLRLRL
        length 6 prefix - sum = 0
        length 4 prefix - sum =0
        od indeks 2 do pred 6, ima suma 0
        toa znaci deka ako se deli prvite 2 so slednite 4, se balansirani
        */

import java.util.Scanner;

public class SplitBalanceString1221 {

    public static int balanceStrings(String s) {
        int brojac = 0;
        //R=+,L=-;
        int currSum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                currSum++;
            } else if (c=='L'){
                currSum--;
            }
            if (currSum == 0) {
                brojac++;
            }
        }
        return brojac;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(balanceStrings(s));
    }
}
