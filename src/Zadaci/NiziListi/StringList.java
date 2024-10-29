package Zadaci.NiziListi;

import java.util.Scanner;

// A list of strings is given. Write a method that will move the nodes with a string length of a number by input
// to the front of the list. The order of the nodes should not be changed.

public class StringList {

    public static void main(String[] args) {
        SLL<String> sll = new SLL<String>();
        Scanner sc = new Scanner(System.in);

        // Read the number of strings to be inserted
        int N = sc.nextInt();
        sc.nextLine();  // Consume the newline after reading the integer

        // Read strings and insert them into the linked list
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            sll.insertLast(str);
        }

        // Read the target string length to move to the front
        int length = sc.nextInt();

        // Initialize pointers for traversing the list
        SLLNode<String> tmp = sll.getFirst();
        SLLNode<String> prev = null;

        // Traverse the list and move matching nodes to the front
        while (tmp != null) {
            // Check if the current node's string length matches the target length
            if (tmp.element.length() == length) {
                if (prev != null) {
                    // Move the current node to the front
                    prev.succ = tmp.succ;  // Remove tmp from its current position
                    tmp.succ = sll.getFirst();  // Insert tmp at the beginning
                    sll.setFirst(tmp);  // Update the first node
                    tmp = prev.succ;  // Move to the next node
                } else {
                    // If the node is already at the front, just move to the next node
                    tmp = tmp.succ;
                }
            } else {
                // Move to the next node
                prev = tmp;
                tmp = tmp.succ;
            }
        }

        // Print the modified list
        System.out.println(sll.toString());
    }
}
