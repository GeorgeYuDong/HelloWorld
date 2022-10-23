package src.company.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSample {

    static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(new IntegerComparator());
        treeSet.add(111);
        treeSet.add(191);
        treeSet.add(181);
        treeSet.add(171);
        treeSet.add(161);
        System.out.println("treeSet = " + treeSet);

    }
}
