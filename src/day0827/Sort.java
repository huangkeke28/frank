package day0827;

import java.util.Arrays;

//七种常见的排序算法
public class Sort {
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
    //插入排序
    public static void insertSort(int[] array) {
        //通过bound来划分出两个区间
        //[0, bound)已排序区间
        //[bound, size)待排序区间
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1; //已排区间的最后一个元素
            for (; cur >= 0; cur--) {
                if (v < array[cur]) {
                    array[cur + 1] = array[cur];
                } else {
                    //说明已经找到适合的位置
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }
}
