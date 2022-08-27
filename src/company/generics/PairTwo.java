package src.company.generics;

public class PairTwo <S, U>{
    S first;
    U second;

    public PairTwo(S first, U second) {
       this.first = first;
       this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    //泛型会进行类型擦除，替换为Object
    //但泛型的好处，在于类型安全，在编译时，可以看到参数类型，及时报错
    //
    //有些 Java 老手说，要把一个小白变成老油条咋办？简单，丢进项目组里面混一段时间就好了。
    // 当你出来后，你会发现你所学习的 Java 不再是很多零散的知识点了，而是一个体系。
    // 多去读一读别人的代码，不要抵触新知识，是学习计算机科学，也亦是学习编程的一条相对来说的“捷径”。
    // 甚至你在学习新知识的时候，可以尝试把新老知识结合一下，当你成功了以后，这种点点滴滴的成就感，也会督促你继续前进。
    // 所以，看一本书，不要顺着看，这不是编程的学习方法所在！
    public static void main(String[] args) {
        PairTwo<Integer, String> pairTwo = new PairTwo<>(123, "china");
        System.out.println(pairTwo.getFirst());
        System.out.println(pairTwo.getSecond());
    }
}
