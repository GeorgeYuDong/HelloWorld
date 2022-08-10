package company.basic;

public class MulArray {
    public static void printMax(int[] numbers) {
        if (numbers.length == 0) {
            return;
        }

        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 223, 3, 5, 8, 128};
        printMax(arr);
    }


}
