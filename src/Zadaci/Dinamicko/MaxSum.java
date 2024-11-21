package Zadaci.Dinamicko;

import java.util.Scanner;

public class MaxSum {
    public static int robot(int[][] a, int m, int n) {
        int[][] b = new int[m][n];

        b[0][0] = a[0][0];
        for (int i = 1; i < m; i++) {
            b[i][0] = b[i - 1][0] + a[i][0]; //na istata pozicija od a i pred nego vo kolonata
        }

        for (int j = 1; j < n; j++) {
            b[0][j] = a[0][j] + b[0][j - 1]; //na istata pozicija od a i pred nego vo redot
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                b[i][j] = a[i][j] + Math.max(b[i - 1][j], b[i][j - 1]); //na istata pozicija od a i dodadi max od pred nego vo redot ili kolonata
            }
        }
        //at the end every cell contains the maximum sum of the path to that cell

        //print the path
        int i = m - 1, j = n - 1;
        while (i > 0 && j > 0) {
            System.out.print("(" + i + "," + j + ") ");
            if (b[i - 1][j] > b[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return b[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(robot(matrix, rows, columns));
    }
}
