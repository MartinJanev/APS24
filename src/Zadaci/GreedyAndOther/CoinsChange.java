package Zadaci.GreedyAndOther;

public class CoinsChange {

    int[] coins = {50, 10, 5, 2, 1};
    int[] coinsNum = new int[5];

    public void sortMoney(int[] coins, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (coins[i] < coins[j]) {
                    int temp = coins[i];
                    coins[i] = coins[j];
                    coins[j] = temp;
                }
            }
        }
    }

    int greedyCoins(int[] coins, int n, int sum, int coinsNum[]) {
        sortMoney(coins, n);
        int i = 0;
        int br = 0;
        while (sum > 0) {
            coinsNum[i] = sum / coins[i];
            sum -= coinsNum[i] * coins[i];
            br += coinsNum[i];
            i++;
        }
        while (i<n){
            coinsNum[i] = 0;
            i++;
        }

        return br;
    }
}
