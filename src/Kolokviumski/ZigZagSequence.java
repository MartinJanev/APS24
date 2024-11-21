package Kolokviumski;


import java.util.Scanner;

public class ZigZagSequence {

    public static int najdiNajdolgaCikCak(int a[]) {
        int count = 1, max = 1, n = a.length;
        for (int i = 1; i < n; i++) {
            if ((a[i] > 0 && a[i - 1] < 0) || (a[i] < 0 && a[i - 1] > 0)) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) throws Exception {
        int i;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int a[] = new int[N];
        for (i = 0; i < N; i++)
            a[i] = sc.nextInt();

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);


    }

}
