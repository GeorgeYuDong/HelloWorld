package company.generics;

import company.Pair;

public class PairOne<T> {
    T first;
    T second;

    public PairOne(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public static void main(String[] args) {
        PairOne<Integer> pairOne = new PairOne<>(11, 22);
        System.out.println(pairOne.getFirst());
        System.out.println(pairOne.getSecond());
    }
}
