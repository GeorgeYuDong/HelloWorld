package src.company.io.stream;

import java.io.*;

public class FileStreamTest {
    public static void main(String[] args) {

        File file = new File("/Users/yudong/a.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            System.out.println(fileInputStream);

            // new 数组，new Object[]
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            for (byte b :
                    bytes) {
                System.out.println(b);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file1 = new File("/Users/yudong/c.txt");
        byte[] data = {88, 89};
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(data);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
