package Kolokviumski.VtorKolokvium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class KumanovskiDijalekt {

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
            return "<" + key + "," + value + ">";
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

        private int hash(String key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public String search(K targetKey) {
            int b = hash((String) targetKey);
            for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (targetKey.equals(curr.element.key)) {
                    return (String) curr.element.value;
                }
            }
            return null;
        }

        public void insert(K key, E val) {
            MapEntry<K, E> newEntry = new MapEntry<>(key, val);
            int b = hash((String) key);
            for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (key.equals(curr.element.key)) {
                    curr.element = newEntry;
                    return;
                }
            }
            buckets[b] = new SLLNode<>(newEntry, buckets[b]);
        }

        public void delete(K key) {
            int b = hash((String) key);
            for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
                if (key.equals(curr.element.key)) {
                    if (pred == null)
                        buckets[b] = curr.succ;
                    else
                        pred.succ = curr.succ;
                    return;
                }
            }
        }

        public String toString() {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < buckets.length; i++) {
                temp.append(i).append(":");
                for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                    temp.append(curr.element).append(" ");
                }
                temp.append("\n");
            }
            return temp.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, String> map = new CBHT<>(N * 50);
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\s+");
            map.insert(input[0], input[1]);
        }

        String tekst = br.readLine();
        String[] words = tekst.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            boolean hasSpecialChar = false;
            boolean startsWithCapital = false;
            String specialChar = "";

            if (words[i].matches(".*[.,!?]$")) {
                hasSpecialChar = true;
                specialChar = words[i].substring(words[i].length() - 1);
                words[i] = words[i].substring(0, words[i].length() - 1);
            }

            if (Character.isUpperCase(words[i].charAt(0))) {
                startsWithCapital = true;
                words[i] = words[i].toLowerCase();
            }

            String translated = map.search(words[i]);
            if (translated != null) {
                words[i] = translated;
            }

            if (startsWithCapital) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }

            if (hasSpecialChar) {
                words[i] += specialChar;
            }

            System.out.print(words[i] + (i < words.length - 1 ? " " : ""));
        }
    }
}
