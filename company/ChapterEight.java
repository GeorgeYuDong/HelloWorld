package company;

/**
 * @author yudong
 */
public class ChapterEight {

    /**
     * 类，接口，方法都可以是泛型的
     *
     * 包装类型是不可变的
     * 无setter方法
     * 基本类型私有，final
     * 不能被继承
     * */

    static class Pair<T,V> {
        T first;
        V second;
        public Pair(T first, V second) {
           this.first = first;
           this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        /**
         * 泛型方法：
         * 返回值int前加了一个<T>
         * 与类是否是泛型无关
         * */
        static <T> int indexOf(T[] arr, T elem){
            for (int i = 0; i < arr.length; i++) {
               if(arr[i].equals(elem)){
                   return i;
               }
            }
            return -1;
        }


        /**
         * 泛型通过类型擦除实现，插入必要的强制类型转换
         * 虚拟机运行时只知道Pair,不知道Pair<Integer,String>
         * */
        public static void main(String[] args) {
            Pair<Integer,String> pair = new Pair<>(1,"jun");
            System.out.println("first value is:" + pair.getFirst());
            System.out.println("second value is:" + pair.getSecond());

            System.out.println(indexOf(new Integer[]{1,2,3,4}, 0));
        }
    }

}
