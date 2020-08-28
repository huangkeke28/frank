package day0827;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 8};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }
}
