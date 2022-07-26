package company.datastructure;

public class MsHashTable<K, V> {

    private Node<K, V>[] table;

    private static class Node<K, V> {
        final int hash;
        final K key;

        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MsHashTable(int capacity) {
        table = (Node<K, V>[]) new Node[capacity];
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int i = (table.length - 1) & hash;
        Node<K, V> node = new Node<>(hash, key, value, null);
        Node<K, V> kvNode = table[i];
        if (kvNode == null) {
            table[i] = node;
            return;
        }
        if (kvNode.key.equals(key)) {
            kvNode.value = value;
        } else {
            kvNode.next = node;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int i = (table.length - 1) & hash;
        Node<K, V> node = table[i];
        if (node == null) {
            return null;
        }
        Node<K, V> newNode = node;
        while (newNode.next != null) {
            if (newNode.key.equals(key)) {
                break;
            }
            newNode = newNode.next;
        }
        return newNode.value;
    }

    //hash函数
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        MsHashTable<String, String> msHashTable = new MsHashTable<>(10);
        msHashTable.put("key1", "china");
        msHashTable.put("key2", "USA");
        msHashTable.put("key3", "JAPAN");

        msHashTable.put("key2", "AUS");
        System.out.println(msHashTable.get("key1"));
        System.out.println(msHashTable.get("key2"));

        var key = "123";
        int h = key.hashCode();
        System.out.println(h);
        System.out.println(h ^ (h >>> 16));

        int a = 0b100;
        int b = a >>> 2;
        System.out.println(b);
        System.out.println(a ^ b); //异或
    }
}
