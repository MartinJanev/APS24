package Zadaci.GreedyAndOther;

import java.util.Arrays;
import java.util.Scanner;

public class MovesToSeatStudents2037 {
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }
        System.out.println(minMovesToSeat(seats, students));
    }
}
