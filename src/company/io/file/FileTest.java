package src.company.io.file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/yudong/a.txt");
        boolean exists = file.exists();
        System.out.println(exists);

        System.out.println(file.isFile());

        String name = file.getName();
        System.out.println(name);

        String parent = file.getParent();
        System.out.println(parent);

        System.out.println(file.length());

        System.out.println(file.lastModified());


    }
}
