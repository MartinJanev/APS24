package Kolokviumski.PrvKolokvium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baseball682 {
    public static int calPoints(String[] operations) {
        //An integer x.
        //Record a new score of x.
        //'+'.
        //Record a new score that is the sum of the previous two scores.
        //'D'.
        //Record a new score that is the double of the previous score.
        //'C'.
        //Invalidate the previous score, removing it from the record.
        int sum, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            char ch = operation.charAt(0);
            if (Character.isDigit(ch) || ch == '-') {
                stack.push(Integer.parseInt(operation));
            } else if (ch == 'C') {
                stack.pop();
            } else if (ch == 'D') {
                stack.push(stack.peek() * 2);
            } else if (ch == '+') {
                int num1 = stack.pop();
                sum = stack.peek() + num1;
                stack.push(num1);
                stack.push(sum);
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] operations = input.split(" ");

        System.out.println(calPoints(operations));
    }
}
