package Auditoriski.NiziListi;

//За дадена низа од N (1<=N<=50) природни броеви, да се наjде броjот коj е наjб-
//лиску до нивниот просек. Ако постоjат два броjа со исто растоjание до просекот,
//да се врати помалиот од нив. Во низата може да има дупликати.
//22
//Податочни структури
//На пример за низата 1, 2, 3, 4, 5 просекот е (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5
//= 3, што значи дека броjот коj треба да се врати и е наjблиску до просекот е 3.
//За низата 1, 2, 3, 4, 5, 6 просекот е 3.5 и двата броjа 3 и 4 се на исто растоjание
//од просекот. Точната вредност коjа треба да се врати е помалиот од нив, а тоа е
//3.
//Првиот броj од влезот

import java.util.Scanner;

public class ArrayMean {

    public static int findClosestToMean(Array<Integer> arr) {
        int suma = 0, index = 0;
        for (int i = 0; i < arr.getSize(); i++) {
            suma += arr.get(i);
        }

        int mean = suma / arr.getSize();
        int minDiff = Math.abs(arr.get(0) - mean);
        for (int i = 1; i < arr.getSize(); i++) {
            if (Math.abs(arr.get(i) - mean) < minDiff) {
                minDiff = Math.abs(arr.get(i) - mean);
                index = i;
            } else if (Math.abs(arr.get(i) - mean) == minDiff) {
                if (arr.get(i) < arr.get(index)) {
                    index = i;
                }
            }
        }
        return arr.get(index);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        Array<Integer> arr = new Array<>(N);
        for (int i = 0; i < N; i++) {
            arr.insertLast(scanner.nextInt());
        }
        System.out.println(findClosestToMean(arr));
    }
}
