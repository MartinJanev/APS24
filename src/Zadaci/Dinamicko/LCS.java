package Zadaci.Dinamicko;

import java.util.Scanner;

public class LCS {
    public static int longestSubseq(int[] a, int[] b) {
        int[][] dp = new int[a.length + 1][b.length + 1]; //defining a 2D array to store the length of the longest common subsequence

        for (int i = 1; i <= a.length; i++) { //iterating through the first array
            for (int j = 1; j <= b.length; j++) { //iterating through the second array
                if (a[i - 1] == b[j - 1]) { //if the elements at the current indices are equal starting from 0
                    dp[i][j] = dp[i - 1][j - 1] + 1; //increment the length of the longest common subsequence by 1 - diagonally add 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //otherwise, take the maximum of the two previous elements - above or left
                }
            }
        }
        //now reconstruct the longest common subsequence from end to start
        //save the elements in array and print them in reverse order
        int i = a.length;
        int j = b.length;
        int[] lcs = new int[dp[a.length][b.length]]; //create an array to store the longest common subsequence
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) { //if the elements are equal starting diagonally from the end
                lcs[dp[i][j] - 1] = a[i - 1]; //store the element in the array
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) { //if the element above is greater than the element on the left
                i--;
            } else {//if the element on the left is greater than the element above
                j--;
            }
        }
        for (int k = 0; k < dp[a.length][b.length]; k++) {
            System.out.print(lcs[k] + " "); //print the longest common subsequence
        }
        System.out.println();
        return dp[a.length][b.length]; //return the length of the longest common subsequence - last element in the 2D array
    }


    public static int longestSubseqStr(String a, String b) {
        //abcd - abc
        //acbd - acb
        //+d vo podnizata

        //ako se razlicni - kratime ili od ednata ili od drugata
        //sushtinski presmetuvame za sekoj par prefiksi na 2ta stringa
        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen + 1][bLen + 1];
        //vo i se cuva prefiksot na a so dolzina i
        //vo i se cuva prefiksot na b so dolzina j

        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;//resenie bez zaednickiot + 1
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]); //ne e vklucen posl. char od a
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]); //ne e vklucen posl. char od b
            }
        }
        return dp[aLen][bLen];
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 2, 4, 5};
//        int[] b = {1, 2, 3, 4, 5};
//        int lcs = longestSubseq(a, b);
//        System.out.println(lcs);

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(longestSubseqStr(a, b));
    }
}


