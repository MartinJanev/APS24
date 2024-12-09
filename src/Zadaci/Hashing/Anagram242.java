package Zadaci.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram242 {

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (mapa.containsKey(ch)) {
                mapa.put(ch, mapa.get(ch) + 1);
            } else {
                mapa.put(ch, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if (mapa.get(ch) != null) {
                if (mapa.get(ch) == 1) {
                    mapa.remove(ch);
                } else {
                    mapa.put(ch, mapa.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return mapa.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isAnagram(s, t));
    }
}
