package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class GasStation134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0, sumCost = 0;
        for (int station : gas) {
            sumGas += station;
        }
        for (int station : cost) {
            sumCost += station;
        }

        if (sumCost > sumGas) {//if total cost is bigger than gas, then -1
            return -1;
        }

        int currGas = 0, start = 0; // we keep track of current gas and starting point
        for (int i = 0; i < gas.length; i++) {
            currGas += gas[i] - cost[i]; //at each station, we subtract cost of the journey from the gas available
            if (currGas < 0) { //if we run out of gas, we start from the next station
                currGas = 0;
                start = i + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] gas = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            gas[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cost[i] = input.nextInt();
        }
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
