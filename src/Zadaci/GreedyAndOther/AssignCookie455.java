package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class AssignCookie455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index1 = 0;
        int index2 = 0;

        while (index1<g.length){
            if (index2==s.length){
                break;
            }
            if (g[index1]<=s[index2]){
                index1++;
            }
            index2++;
        }
        return index1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();//number of children
        int s = sc.nextInt();//number of cookies

        int[] children = new int[g];
        int[] cookies = new int[s];

        for (int i = 0; i < g; i++) {
            children[i] = sc.nextInt();
        }
        for (int i = 0; i < s; i++) {
            cookies[i] = sc.nextInt();
        }

        System.out.println(findContentChildren(children, cookies));
    }
}
