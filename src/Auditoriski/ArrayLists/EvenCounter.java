package Auditoriski.ArrayLists;

import java.util.Scanner;

public class EvenCounter {
    public static int evenNum(SLL<Integer> list){
        SLLNode<Integer> tmp = list.getFirst();
        int br=0;
        while (tmp!=null){
            if (tmp.element%2==0){
                br++;
            }
            tmp=tmp.succ;
        }
        return br;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        System.out.println("Num of even numbers: " + evenNum(list));
    }

}
