package Kolokviumski;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZalutaniBroevi {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] broevi = new int[n];
        List<int[]> zalutani = new ArrayList<>();
        //[0,1]
        for (int i = 0; i < n; i++) {
            broevi[i] = in.nextInt();
        }
        for (int i = 1; i < n; i++) {
            int br = 0;
            for (int k = i - 1; k >= 0; k--) {
                if (broevi[i] < broevi[k]) { //if we find bigger number than the current one
                    br++;
                } else {
                    break;
                }
            }
            if (br > 0) {
                int[] pom = new int[2];
                pom[0] = broevi[i];
                pom[1] = br;
                zalutani.add(pom);
            }
        }
        System.out.println(zalutani.size());
        for (int i = 0; i < zalutani.size(); i++) {
            System.out.println(zalutani.get(i)[0] + " " + zalutani.get(i)[1]);
        }
    }
}
