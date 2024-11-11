package Zadaci.Dinamicko.Videa;

public class FibonaciTB {
    static int[] memo;

    public static int fib(int n) {
        if (memo[n] != 0) { // Check if the value is already calculated
            return memo[n];
        }
        if (n <= 2) { // Base case
            return 1;
        }
        memo[n] = fib(n - 1) + fib(n - 2); // Recursive call of the function for the n-th Fibonacci number
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 50;
        memo = new int[n + 1];
        System.out.println(fib(n));
    }
}
