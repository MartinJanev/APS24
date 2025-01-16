package Kolokviumski.VtorKolokvium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostFrequentSubstring {

    static class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

        K key;
        E value;

        public MapEntry(K key, E val) {
            this.key = key;
            this.value = val;
        }

        public int compareTo(K that) {
            @SuppressWarnings("unchecked")
            MapEntry<K, E> other = (MapEntry<K, E>) that;
            return this.key.compareTo(other.key);
        }

        public String toString() {
            return "(" + key + "," + value + ")";
        }
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

    static class CBHT<K extends Comparable<K>, E> {

        private SLLNode<MapEntry<K, E>>[] buckets;

        @SuppressWarnings("unchecked")
        public CBHT(int m) {
            buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
        }

        private int hash(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public SLLNode<MapEntry<K, E>> search(K targetKey) {
            int b = hash(targetKey);
            for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                    return curr;
            }
            return null;
        }

        public void insert(K key, E val) {        // Insert the entry <key, val> into this CBHT.
            MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
            int b = hash(key);
            for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                    curr.element = newEntry;
                    return;
                }
            }
            buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
        }

        public void delete(K key) {
            int b = hash(key);
            for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
                if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                    if (pred == null)
                        buckets[b] = curr.succ;
                    else
                        pred.succ = curr.succ;
                    return;
                }
            }
        }

        public String toString() {
            String temp = "";
            for (int i = 0; i < buckets.length; i++) {
                temp += i + ":";
                for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                    temp += curr.element.toString() + " ";
                }
                temp += "\n";
            }
            return temp;
        }

    }

    public static int sodrzi(String word, String substr) {
        int br = -1;
        String str;
        while (true) {
            str = word.replaceFirst(substr, "^");
            if (str.equals(word))
                return br;
            else {
                br++;
                word = str;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CBHT<String, Integer> substringFrequencyTable = new CBHT<>(300);
        CBHT<String, Integer> usedSubstrings = new CBHT<>(300);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();

        String currentSubstring = "" + input.charAt(0);
        int nextStartIndex = 1;

        // Populate substring frequency table
        substringFrequencyTable.insert(currentSubstring, sodrzi(input, currentSubstring));
        for (int i = 1; i < input.length(); i++) {
            currentSubstring += input.charAt(i);

            if (sodrzi(input, currentSubstring) == 0) {
                currentSubstring = "";
                i = nextStartIndex++;
            } else if (substringFrequencyTable.search(currentSubstring) == null) {
                substringFrequencyTable.insert(currentSubstring, sodrzi(input, currentSubstring));
            }
        }

        // Find the most frequent substring
        int maxFrequency = 0;
        int maxLength = 0;
        String mostFrequentSubstring = null;

        currentSubstring = "";
        nextStartIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            currentSubstring += input.charAt(i);

            if (sodrzi(input, currentSubstring) == 0) {
                currentSubstring = "";
                i = ++nextStartIndex;
            } else if (usedSubstrings.search(currentSubstring) == null) {
                usedSubstrings.insert(currentSubstring, 1);

                MapEntry<String, Integer> entry = substringFrequencyTable.search(currentSubstring).element;
                int frequency = entry.value;
                String substring = entry.key;

                if (frequency > maxFrequency || (frequency == maxFrequency && substring.length() > maxLength) ||
                        (frequency == maxFrequency && substring.length() == maxLength && substring.compareTo(mostFrequentSubstring) < 0)) {
                    maxFrequency = frequency;
                    maxLength = substring.length();
                    mostFrequentSubstring = substring;
                }
            }
        }

        System.out.println(mostFrequentSubstring != null ? mostFrequentSubstring : input);
    }}
