package company;

/**
 * @author yudong
 */
public class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("ABC", 100);
        System.out.println(pair.first);
        System.out.println(pair.second);
    }

}
