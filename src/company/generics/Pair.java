package src.company.generics;

public class Pair implements Comparable<Pair> {

    public int id;

    public Pair(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Pair o) {
        return this.id - o.id;
    }

    /**
     * 定义了泛型方法, 该类型必须实现了Comparable接口
     * */
    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) <= 0) {
            return a;
        } else return b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //作为方法参数时，类型参数不能extends或者super类型参数
    //? extends T 不能写数据，只能读数据
    public <T, D extends T> void getX(DynamicArray<? extends T> a){

    }

    public static void main(String[] args) {
        Pair pair1 = new Pair(12);
        Pair pair2 = new Pair(34);
        Pair pair3 = max(pair1, pair2);
        System.out.println(pair3 == pair1);
        System.out.println(pair3 == pair2);
    }
}
