package Kolokviumski;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        int result = 0;
        Stack<Integer> stek = new Stack<>();
        String[] zbirSplit = expression.split("\\+");

        for (String sobirok : zbirSplit) {
            String[] proizvodSplit = sobirok.split("\\*");
            int proizvod = 1;
            for (String mnozitel : proizvodSplit) {
                proizvod *= Integer.parseInt(mnozitel);
            }
            stek.push(proizvod);
        }

        while (!stek.isEmpty()) {
            result += stek.pop();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}