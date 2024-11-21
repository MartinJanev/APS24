package Kolokviumski;

// /a//a/a/a/b/c/x/a/.4

import Packages.StackQueue.Stack;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CanonicalPath {

    public static String simplifyPath(String path) {
        LinkedStack<String> stack = new LinkedStack<>();

        // Split the input path by "/"
        String[] components = path.split("/");

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                // Skip empty components or "."
                continue;
            } else if (component.startsWith(".") && isNumber(component.substring(1))) {
                // Handle ".k" where k is a positive integer
                int levelsUp = Integer.parseInt(component.substring(1));
                for (int i = 0; i < levelsUp && !stack.isEmpty(); i++) {
                    stack.pop();
                }
            } else {
                // Regular directory or file name, push it onto the stack
                stack.push(component);
            }
        }

        // Reconstruct the canonical path from the stack
        StringBuilder canonicalPath = new StringBuilder();
        LinkedStack<String> reverseStack = new LinkedStack<>();

        // Reverse the stack to build the path in the correct order
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }

        while (!reverseStack.isEmpty()) {
            canonicalPath.append("/").append(reverseStack.pop());
        }

        // Return "/" if stack is empty, else return the constructed path
        if (!canonicalPath.isEmpty()) {
            return canonicalPath.toString();
        }
        return "/";
    }

    // Helper method to check if a string represents a number
    private static boolean isNumber(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println(simplifyPath(path));
    }

    static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    static class LinkedStack<E> implements Stack<E> {
        // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
        private SLLNode<E> top;
        int size;

        public LinkedStack() {
            // Konstrukcija na nov, prazen stek.
            top = null;
            size = 0;
        }

        public String toString() {
            SLLNode<E> current = top;
            StringBuilder s = new StringBuilder();
            while (current != null) {
                s.append(current.element);
                s.append(" ");
                current = current.succ;
            }
            return s.toString();
        }

        public boolean isEmpty() {
            // Vrakja true ako i samo ako stekot e prazen.
            return (top == null);
        }

        public void clear() {
            // Go prazni stekot.
            top = null;
            size = 0;
        }

        public E peek() {
            // Go vrakja elementot na vrvot od stekot.
            if (top == null)
                throw new NoSuchElementException();
            return top.element;
        }

        public void push(E x) {
            // Go dodava x na vrvot na stekot.
            top = new SLLNode<E>(x, top);
            size++;
        }

        public int size() {
            // Ja vrakja dolzinata na stekot.
            return size;
        }

        public E pop() {
            // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
            if (top == null)
                throw new NoSuchElementException();
            E topElem = top.element;
            size--;
            top = top.succ;
            return topElem;
        }

    }


}
