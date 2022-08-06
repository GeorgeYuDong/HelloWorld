package company.algorithm;

public class Sort {

    public void insertionSort(int[] arr, int n) {
        if (1 >= n) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            //look for inserted location
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j]; // data moving
                } else {
                    break;
                }
            }
            arr[j + 1] = value; //insert data
        }
    }
}
