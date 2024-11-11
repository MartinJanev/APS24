package Zadaci.DivideAndConquer;

public class nDegree {
    public static void main(String[] args) {
        System.out.println(power(10, 20));
    }

    public static int power(int k, int n) {
        if (n == 0) return 1;
        if (n == 1) {
            return k;
        }
        if (n % 2 == 0) {
            return power(k, n / 2) * power(k, n / 2);
        } else {
            return k * power(k, n / 2) * power(k, n / 2);
        }

    }
}
