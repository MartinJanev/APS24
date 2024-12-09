package Zadaci.Hashing;


import java.util.Scanner;

public class NajdobraPonuda {

    static class MapEntry<K extends Comparable<K>, E> {
        // Each MapEntry object is a pair consisting of a key (a Comparable object)
        // and a value (an arbitrary object).
        K key;
        E value;

        public MapEntry(K key, E val) {
            this.key = key;
            this.value = val;
        }

        public String toString() {
            return "<" + key + "," + value + ">";
        }
    }

    static class CBHT<K extends Comparable<K>, E> {

        // An object of class CBHT is a closed-bucket hash table, containing
        // entries of class MapEntry.
        private SLLNode<MapEntry<K, E>>[] buckets;

        @SuppressWarnings("unchecked")
        public CBHT(int m) {
            // Construct an empty CBHT with m buckets.
            buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
        }

        private int hash(K key) {
            // Translate key to an index of the array buckets.
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public SLLNode<MapEntry<K, E>> search(K targetKey) {
            // Find which if any node of this CBHT contains an entry whose key is equal to targetKey.
            // Return a link to that node (or null if there is none).
            int b = hash(targetKey);
            SLLNode<MapEntry<K, E>> currNode = buckets[b];
            while (currNode != null) {
                MapEntry<K, E> currEntry = currNode.element;
                if (currEntry.key.equals(targetKey)) return currNode;
                else currNode = currNode.succ;
            }
            return null;
        }

        public void insert(K key, E val) {
            // Insert the entry <key, val> into this CBHT.
            // If entry with same key exists, overwrite it.
            MapEntry<K, E> newEntry = new MapEntry<>(key, val);
            int b = hash(key);
            SLLNode<MapEntry<K, E>> currNode = buckets[b];
            while (currNode != null) {
                MapEntry<K, E> currEntry = currNode.element;
                if (currEntry.key.equals(key)) {
                    // Make newEntry replace the existing entry ...
                    currNode.element = newEntry;
                    return;
                } else currNode = currNode.succ;
            }
            // Insert newEntry at the front of the SLL in bucket b ...
            buckets[b] = new SLLNode<>(newEntry, buckets[b]);
        }

        public void delete(K key) {
            // Delete the entry (if any) whose key is equal to key from this CBHT.
            int b = hash(key);
            SLLNode<MapEntry<K, E>> predNode = null, currNode = buckets[b];
            while (currNode != null) {
                MapEntry<K, E> currEntry = currNode.element;
                if (currEntry.key.equals(key)) {
                    if (predNode == null) buckets[b] = currNode.succ;
                    else predNode.succ = currNode.succ;
                    return;
                } else {
                    predNode = currNode;
                    currNode = currNode.succ;
                }
            }
        }

        public String toString() {
            String temp = "";
            for (int i = 0; i < buckets.length; i++) {
                temp += i + ":";
                SLLNode<MapEntry<K, E>> curr = buckets[i];
                while (curr != null) {
                    temp += curr.element.toString() + " ";
                    curr = curr.succ;
                }
                temp += "\n";
            }
            return temp;
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

    static class Lecture {
        String date, time, place;
        int fee;

        public Lecture(String date, String time, String place, int fee) {
            this.date = date;
            this.time = time;
            this.place = place;
            this.fee = fee;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        CBHT<String, Lecture> mapa = new CBHT<>(2 * n);
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            String date = arr[0];
            String time = arr[1];
            String place = arr[2];
            int fee = Integer.parseInt(arr[3]);

            Lecture p = new Lecture(date, time, place, fee);
            if (mapa.search(p.getDate()) == null) {
                mapa.insert(p.getDate(), p);
            } else {
                SLLNode<MapEntry<String, Lecture>> best_for_date = mapa.search(p.getDate());
                Lecture best = best_for_date.element.value;
                if (p.getFee() > best.getFee()) {
                    mapa.insert(p.getDate(), p);
                }
            }
        }
        String inputData = sc.next();
        SLLNode<MapEntry<String, Lecture>> result = mapa.search(inputData);
        if (result != null) {
            Lecture bestLecture = result.element.value;
            System.out.println(bestLecture.getTime() + " " + bestLecture.getPlace() + " " + bestLecture.getFee());
        }else{
            System.out.println("No match");
        }
    }
}
