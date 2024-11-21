package Zadaci.GreedyAndOther;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivitySelector {

    // Greedy algorithm for Activity Selection
    public static List<Integer> activitySelection(int[] start, int[] finish) {
        int n = start.length;

        // List to store indices of selected activities
        List<Integer> selectedActivities = new ArrayList<>();

        // First activity always gets selected
        selectedActivities.add(0);
        int lastSelected = 0; // Index of the last selected activity

        // Iterate over the remaining activities
        for (int i = 1; i < n; i++) {
            // If the start time of the current activity is >= finish time of the last selected
            if (start[i] >= finish[lastSelected]) {
                selectedActivities.add(i); // Select the current activity
                lastSelected = i; // Update the last selected activity index
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of activities
        System.out.println("Enter the number of activities:");
        int n = sc.nextInt();

        // Input start and finish times
        int[] start = new int[n];
        int[] finish = new int[n];
        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        System.out.println("Enter finish times:");
        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }

        // Find the maximum set of activities
        List<Integer> result = activitySelection(start, finish);

        // Print the result
        System.out.println("Selected activities (by index):");
        for (int index : result) {
            System.out.print(index + " ");
        }
    }
}
