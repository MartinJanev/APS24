package Zadaci.VovedJava;

import java.util.Scanner;

class QuarterlySales {

    private int numOfSales;
    private int[] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int revenue : revenues) {
            sb.append(revenue).append("\t");
        }
        return sb.toString().trim();
    }

    // Method to calculate the total revenue for the quarter
    public int getRevenue() {
        int sum = 0;
        for (int revenue : revenues) {
            sum += revenue;
        }
        return sum;
    }
}

class SalesPerson {

    private String name;
    private QuarterlySales[] quarters;

    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("   ");
        for (QuarterlySales quarter : quarters) {
            sb.append(quarter.getRevenue()).append("   ");
        }
        sb.append(sumSales());
        return sb.toString();
    }

    // Method to calculate the sum of all revenues across all quarters
    public int sumSales() {
        int total = 0;
        for (QuarterlySales quarter : quarters) {
            total += quarter.getRevenue();
        }
        return total;
    }

    public String getName() {
        return name;
    }
}

public class Main {

    public static SalesPerson salesChampion(SalesPerson[] arr) {
        SalesPerson max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].sumSales() > max.sumSales()) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void table(SalesPerson[] arr) {
        System.out.println("SP   1   2   3   4   Total");
        for (SalesPerson salesPerson : arr) {
            System.out.println(salesPerson);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        SalesPerson[] arr = new SalesPerson[n];

        for (int i = 0; i < n; i++) {
            String name = input.nextLine();
            QuarterlySales[] qs = new QuarterlySales[4];

            for (int j = 0; j < 4; j++) {
                int numOfSales = input.nextInt();
                int[] revenues = new int[numOfSales];

                for (int k = 0; k < numOfSales; k++) {
                    revenues[k] = input.nextInt();
                }

                qs[j] = new QuarterlySales(numOfSales, revenues, j + 1); // Initialize quarterly sales
            }
            input.nextLine();
            arr[i] = new SalesPerson(name, qs);
        }


        table(arr);
        System.out.println();
        System.out.println("SALES CHAMPION: " + salesChampion(arr).getName()); // Output the sales champion
    }
}
