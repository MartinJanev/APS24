import Zadaci.Dinamicko.KnapsackDinamicko;
import Zadaci.GreedyAndOther.KnapSack;

public class BANHAMMER {

//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else return n * stepen(n, k - 1);
//    }

//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else if (k % 2 == 0) {
//            return stepen(n * n, k / 2);
//        } else
//        {
//            return n * stepen(n*n, (k - 1)/2);
//        }
//    }


//    static long stepen(int n, int k) {
//        if (k == 0) return 1;
//        else if (k % 2 == 0) {
//            return stepen(n, k / 2) * stepen(n, k / 2);
//        } else {
//            return n * stepen(n * n, (k - 1) / 2) * stepen(n * n, (k - 1) / 2);
//        }
//    }


    public static void main(String[] args) {
        int[] weight = {10, 7, 4, 2};
        int[] profit = {60, 28, 20, 24};
        int C = 11;
        float res = KnapsackDinamicko.knapsack(C,weight,profit);
        System.out.println(res);
    }
}
