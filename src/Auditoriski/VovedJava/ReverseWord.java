package Auditoriski.VovedJava;

import java.util.Scanner;

public class ReverseWord {

    public static void printReversed(String word) {
        int l = 0, r = word.length() - 1;

        while (l < r) {
            char[] charArray = word.toCharArray();

            // Swap characters at positions l and r
            char temp = charArray[l];
            charArray[l] = charArray[r];
            charArray[r] = temp;

            word = new String(charArray);

            l++;
            r--;
        }

        System.out.println(word);
    }

    public static void main(String[] args) {
        int n;
        String word;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            word = sc.next();
            printReversed(word);
        }
    }
}
