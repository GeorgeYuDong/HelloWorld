package src.company.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestExtendsGenerics<T extends List> {
    public static void main(String[] args) {
        TestExtendsGenerics<ArrayList> arrayListTestExtendsGenerics = new TestExtendsGenerics<>();
        TestExtendsGenerics<LinkedList> linkedListTestExtendsGenerics = new TestExtendsGenerics<>();
     //   TestExtendsGenerics<HashMap>  hashmap没有实现List接口

    }

}
