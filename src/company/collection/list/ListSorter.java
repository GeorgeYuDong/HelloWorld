package src.company.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter {
    class ComparatorSample implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }

    public List<Integer> sort(List<Integer> list) {
        Collections.sort(list, new ComparatorSample() );
        return list;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(130);
        integerList.add(140);
        integerList.add(110);
        integerList.add(100);
        System.out.println("integerList = " + integerList);

        ListSorter listSorter = new ListSorter();
        listSorter.sort(integerList);
        System.out.println("integerList = " + integerList);


    }
}
