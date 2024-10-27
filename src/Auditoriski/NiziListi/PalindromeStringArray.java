package Auditoriski.NiziListi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeStringArray {
    public static boolean areSameChar(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        int N = Integer.parseInt(s);
        Array<String> stringArray = new Array<String>(N);
        s = input.readLine();
        char[] strings = s.toCharArray();
        for (char c : strings) {
            stringArray.insertLast(String.valueOf(c));
        }

        System.out.println(stringArray.toString());
        int l = 0, r = N - 1;
        boolean flag = false;
        while (l < r) {
            if (!areSameChar(stringArray.get(l), stringArray.get(r))) {
                flag = false;
                break;
            }
            flag = true;
            l++;
            r--;

        }
        String s1 = (flag) ? "Yes" : "No";
        System.out.println(s1);
    }
}
