package Kolokviumski.PrvKolokvium;

import java.util.Scanner;

public class LeastDigitsToSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] niza = new int[n];
        niza[0] = 1;
        sum -= 1;
        int len = n-1;
        while (sum > 0){
            if(len < 0){
                System.out.print("Ne postoi");
                return;
            }
            if(sum >= 9){
                niza[len--] = 9;
                sum -= 9;
            }
            else{
                niza[len--] = sum;
                sum = 0;
                break;
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(niza[i]);
        }
    }
}
