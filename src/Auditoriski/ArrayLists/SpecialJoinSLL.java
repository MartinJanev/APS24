package Auditoriski.ArrayLists;

import java.util.Scanner;

public class SpecialJoinSLL<E> {
    public SLL<E> joinSpecialLists(SLL<E> firstList, SLL<E> secondList) {
        SLL<E> result = new SLL<E>();
        SLLNode<E> tmpFirst = firstList.getFirst();
        SLLNode<E> tmpSecond = secondList.getFirst();

        // Loop to add nodes in batches of two from both lists
        while (tmpFirst != null || tmpSecond != null) {
            // Add the next two nodes from the first list, if available
            for (int i = 0; i < 2 && tmpFirst != null; i++) {
                result.insertLast(tmpFirst.element);
                tmpFirst = tmpFirst.succ;
            }
            // Add the next two nodes from the second list, if available
            for (int i = 0; i < 2 && tmpSecond != null; i++) {
                result.insertLast(tmpSecond.element);
                tmpSecond = tmpSecond.succ;
            }
        }

        // If there are remaining nodes in the first list, add them to the result
        while (tmpFirst != null) {
            result.insertLast(tmpFirst.element);
            tmpFirst = tmpFirst.succ;
        }

        // If there are remaining nodes in the second list, add them to the result
        while (tmpSecond != null) {
            result.insertLast(tmpSecond.element);
            tmpSecond = tmpSecond.succ;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        SLL<Integer> list1 = new SLL<Integer>();
        for (int i = 0; i < N1; i++) {
            list1.insertLast(sc.nextInt());
        }

        int N2 = sc.nextInt();
        SLL<Integer> list2=new SLL<Integer>();
        for (int i = 0; i < N2; i++) {
            list2.insertLast(sc.nextInt());
        }

        SpecialJoinSLL<Integer> specialJoinSLL = new SpecialJoinSLL<>();
        SLL<Integer> result = specialJoinSLL.joinSpecialLists(list1, list2);

        System.out.println(result.size()==0?"Empty list":result.toString());
    }
}
