package Labs.ArrayLists;

import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //Иницијализација на скенер за внес
        int N = sc.nextInt();                   //внес на број на елементи на низа
        int[] arr = new int[N];                 //декларираме и иницијализираме низа од N елементи
        double mean = 0;                        //декларираме и иницијализираме број, каде ќе се чува просекот

        for (int i = 0; i < N; i++) {           //За секој елемент во низата внесуваме вредност
            arr[i] = sc.nextInt();              //и ја додаваме на променливата за просек
            mean += arr[i];
        }
        mean /= N;                              //Ја добиваме вредноста на просекот на низата

        print(arr, N);                          //Ја печатиме оригиналната низа
        int index = 0;                          //Т.Н. бројач за внес на оние вредности што треба да се пренесат по
                                                //извршување на барањето
        for (int i = 0; i < N; i++) {
            if (arr[i] >= mean) {               //ако е поголемо или еднакво од просекот, чувај го во низата
                arr[index++] = arr[i];
            }
        }
        print(arr, index);                      //Печатење на трансформираната низа
    }

    public static void print(int[] arr, int value) {

// 1 решение за печатење

//        System.out.print("{");
//        for (int i = 0; i < value; i++) {
//            if (i==value-1){
//                System.out.print(arr[i]);
//            }else {
//                System.out.print(arr[i] + ",");
//            }
//        }
//        System.out.println("}");


// 2 решение за печатење - помалку чекори би се извршиле (нема потреба од проверки)

        System.out.print("{"+arr[0]);
        for (int i = 1; i < value; i++) {
            System.out.print(","+arr[i]);
        }
        System.out.println("}");
    }
}