package Packages.Algos1;

public class DivideAndConquer {

    int INF = 1000000;

    int pow(int x, int n) {
        int r;

        if (n == 0) {
            return (1);
        } else if (n % 2 == 0) {
            r = pow(x, (n / 2));
            return r * r;
        } else {
            r = pow(x, (n / 2));
            return x * r * r;
        }

    }

   
    public static void main(String[] args) {

        DivideAndConquer dac = new DivideAndConquer();

        System.out.println("pow: " + dac.pow(2, 10));

        
    }
}
