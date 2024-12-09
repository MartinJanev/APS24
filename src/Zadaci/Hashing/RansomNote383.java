package Zadaci.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote383 {

    public static boolean isAnagram(String magazine, String ransomNote) {
        HashMap<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            if (mapa.containsKey(ch)) {
                mapa.put(ch, mapa.get(ch) + 1);
            } else {
                mapa.put(ch, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            if (mapa.containsKey(ch)) {
                mapa.put(ch, mapa.get(ch) - 1);
                if (mapa.get(ch) < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isAnagram(t, s));
    }
}
