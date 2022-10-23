package src.company.basic.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class StringTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s1 = "JAVA C++A";
        System.out.println("s1 = " + s1);
        System.out.println("s1 length() is: " + s1.length());
        System.out.println(s1.charAt(5));
        System.out.println(s1.substring(5));
        System.out.println(s1.substring(5,7)); //左闭右开

        System.out.println("s1中A最后出现的位置:" + s1.lastIndexOf('A'));
        System.out.println("s1中A第一次出现的位置:" + s1.indexOf('A'));

        System.out.println("s1中A从index为4开始，第一次出现A的位置为：" + s1.indexOf('A', 4));

        // 字符串转byte数组(8位)
        byte[] arrs = s1.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < arrs.length; i++) {
            System.out.print(arrs[i] + " ");
        }
        System.out.println();

        // 构造方法，把byte数组转换为字符串
        String s = new String(arrs, StandardCharsets.UTF_8);
        System.out.println(s);

        var s2 = "china";
        var s3 = "china";
        System.out.println(s2.equals(s3));
        var s4 = "china";
        System.out.println(s2.equals(s4));
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        var s5 = "china";
        System.out.println(s4 == s5);

        String abc = new String("abc"); // cmd + shift+回车  自动增加分号
        System.out.println(abc);

        ArrayList<String> arrayList = new ArrayList<>(); // cmd + ArrayList 查看ArrayList源代码
        arrayList.add("西游记"); // option + cmd + < 返回 ----+>到上一步代码处
        arrayList.add("水浒传");
        System.out.println(arrayList);
        arrayList.add("西游记后传");
        arrayList.add(2,"三国演义");
        System.out.println(arrayList);

        for (String book:
             arrayList) {
            System.out.print(book + " ");
        }
        System.out.println();
        System.out.println("--------------------");

        arrayList.forEach(book->{
            System.out.print(book + " ");
        });
        System.out.println();
        System.out.println("--------------------");

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.print(next + " ");
        }
        System.out.println();
    }
}
