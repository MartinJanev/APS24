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

        int max = 1;
        for (int i = 0; i < n; i++) {
            int numOverlapping = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[j][0] <= arr[i][0] && arr[j][1] >= arr[i][0])
                        numOverlapping++;
                }

            }
            max = Math.max(max, numOverlapping);
            numOverlapping = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arr[j][0] <= arr[i][1] && arr[j][1] >= arr[i][1])
                        numOverlapping++;
                }

            }
            max = Math.max(max, numOverlapping);


        }
        System.out.print(max);

    }
}
