package Zadaci.Dinamicko;

public class KnapsackDinamicko {

    public static int knapsack(int capacity, int[] weights, int[] values) {

        int numItems = weights.length;
        int[][] dp = new int[numItems + 1][capacity + 1]; // dp[i][j] represents the maximum value that can be obtained with items 1 to i and capacity j

        for (int i = 1; i <= numItems; i++) {
            int weight = weights[i - 1]; // Current item's weight
            int value = values[i - 1]; // Current item's value

            for (int cap = 1; cap <= capacity; cap++) {
                dp[i][cap] = dp[i - 1][cap]; //Value without taking the item
                if (cap >= weight) {// If we can take the item without exceeding the capacity
                    dp[i][cap] = Math.max(dp[i][cap], dp[i - 1][cap - weight] + value); // The max value between taking and not taking the item
                }
            }
        }

        //backtrack to print which items were taken
        int i = numItems;
        int j = capacity;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                System.out.println("Item " + i + " with weight " + weights[i - 1] + " and value " + values[i - 1]);
                j -= weights[i - 1];
            }
            i--;
        }

        return dp[numItems][capacity];
    }

    public static void main(String[] args) {

        int capacity = 10;
        int[] values = {1, 4, 8, 5};
        int[] weights = {3, 3, 5, 6};
        System.out.println(knapsack(capacity, weights, values)); // Output maximum profit

        capacity = 7;
        values = new int[]{2, 2, 4, 5, 3};
        weights = new int[]{3, 1, 3, 4, 2};
        System.out.println(knapsack(capacity, weights, values)); // Output maximum profit
    }
}
