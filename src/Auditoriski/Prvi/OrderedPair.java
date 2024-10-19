package Auditoriski.Prvi;

public class OrderedPair<K, V> {
    private K key;
    private V value;

    @Override
    public String toString() {
        return "OrderedPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public OrderedPair(V value, K key) {
        this.value = value;
        this.key = key;
    }
}
