package Labs.Algos1;

import java.util.Scanner;

public class Meetings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();

            }
        }

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            int cnt1 = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[j][0] <= arr[i][0] && arr[j][1] >= arr[i][0])
                        cnt1++;
                }

            }
            cnt = Math.max(cnt, cnt1);
            cnt1 = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[j][0] <= arr[i][1] && arr[j][1] >= arr[i][1])
                        cnt1++;
                }

            }
            cnt = Math.max(cnt, cnt1);


        }
        System.out.print(cnt);

    }
}
