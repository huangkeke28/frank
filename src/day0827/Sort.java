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
    //时间复杂度:O(N^2)
    //空间复杂度:O(1)
    //稳定性:稳定排序
    //插入排序两个重要特点
    //当待排序区间元素比较少的时候,排序效率很高
    //当整个数组比较接近有序的时候,排序效率也很高
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

    //希尔排序
    //先分组 针对每个组进行插入排序 逐渐缩小组的个数 最终整个数据就接近有序了
    //时间复杂度:理论上能达到O(N^1.3)
    //空间复杂度:O(1)
    //稳定性:不稳定
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            //需要循环进行插排
            insertSortGap(array, gap);
            gap /= 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;//找同组中的上一个元素
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }

    //选择排序:打擂台的思想 每次从数组中找出最小值 然后把最小值放在合适的位置上
    //时间复杂度O(N^2)
    //空间复杂度O(1)
    //稳定性:不稳定排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            //以bound位置的元素作为擂主,循环从待排序区间中抽出元素和擂主进行比较
            //如果打雷成功 就和擂主交换位置
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    //打雷成功
                    int tmp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //堆排序
    //时间复杂度:O(NlogN)
    //空间复杂度:O(1)
    //稳定性:不稳定排序
    //1.把数组建立一个小堆,取出一个最小值放到另外一个数组中,循环取堆顶元素尾插到新数组中即可
    //2.把数组建立一个大堆,把堆顶元素和堆的最后一个元素互换,再重堆顶来向下调整
    //怎么建堆:从最后一个非叶子结点往前遍历,向下调整
    public static void heapSort(int[] array) {
        //先建立堆
        createHeap(array);
        //循环把堆顶元素交换到最后,并进行调整堆
        for (int i = 0; i < array.length - 1; i++) {
            //交换堆顶元素和堆的最后一个元素
            swap(array,0,array.length - 1 - i);
            //交换完成之后堆的长度又进一步缩水
            shiftDown(array, array.length - i - 1, 0);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;

            }
            if (array[child] > array[parent]) {
                swap(array,child,parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void createHeap(int[] array) {
        //从最后一个非叶子结点出发向前循环,依次进行向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array,array.length, i);
        }
    }


    //冒泡排序
    //时间复杂度:O(N^2)
    //空间复杂度:O(1)
    //稳定性:稳定排序
    public static void bubbleSort(int[] array) {
        //按照每次找最小的方式来进行排序 从后往前比较交换
        for (int bound = 0; bound < array.length; bound++) {
            // [0, bound)已排序
            // [bound, size)待排序
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array,cur - 1,cur);
                }
            }
        }
    }
}
