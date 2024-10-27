package Auditoriski.NiziListi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeStringSLL {

    public static boolean isPalindrome(SLL<Character> list) {
        if (list.getFirst() == null) {
            return true;
        }

        SLL<Character> reverseList = new SLL<Character>();
        SLLNode<Character> curr = list.getFirst();

        while (curr != null) {
            reverseList.insertFirst(curr.element);
            curr = curr.succ;
        }

        curr = list.getFirst();
        SLLNode<Character> rCurr = reverseList.getFirst();
        while (curr != null && rCurr != null) {
            if (!curr.element.equals(rCurr.element)) {
                return false;
            }
            curr = curr.succ;
            rCurr = rCurr.succ;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        SLL<Character> list = new SLL<Character>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        SLLNode<String> r = null;
        for (int i = 0; i < s.length(); i++) {
            list.insertLast(Character.toLowerCase(s.charAt(i)));
        }
        System.out.println(list.toString());
        if (isPalindrome(list)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

    }
}
