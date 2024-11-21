package Zadaci.GreedyAndOther;

import java.util.Scanner;

public class HoursToTrain2383 {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int currEnergy = initialEnergy;
        int currExperience = initialExperience;
        int res = 0;
        int diffrence;

        for (int i = 0; i < n; i++) {
            if (energy[i] >= currEnergy) {
                diffrence = energy[i] - currEnergy + 1;
                res += diffrence;
                currEnergy += diffrence;
            }
            currEnergy -= energy[i];
            if (experience[i]>=currExperience){
                diffrence = experience[i] - currExperience + 1;
                res += diffrence;
                currExperience += diffrence;
            }
            currExperience += experience[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initialEnergy = sc.nextInt();
        int initialExperience = sc.nextInt();
        int n = sc.nextInt();
        int[] energy = new int[n];
        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }
        int[] experience = new int[n];
        for (int i = 0; i < n; i++) {
            experience[i] = sc.nextInt();
        }

        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));

    }
}
