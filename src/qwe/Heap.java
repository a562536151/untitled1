package qwe;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
            int[] a = new int[]{5, 4, 11, 1, 2, 3, 6, 1, 6, 2};
                heapSort(a);
        System.out.println(Arrays.toString(a));//System.out.print(Arrays.deepToString(gameboardTwo));二维用这个
        }


    public static void heapSort(int[] arr) {
        // 构建初始大顶堆
        buildMaxHeap(arr);                  //先建堆，建完了堆就有一个最大值在堆最前面
        for (int i = arr.length - 1; i >= 0; i--) { //可以理解为一个数组第一个位置是最大值，然后不停维护最大值后面的元素
            // 将最大值交换到数组最后
            swap(arr, i, 0);
            // 调整剩余数组，使其满足大顶堆
            maxHeapify(arr, 0, i);
        }
    }
    // 构建初始大顶堆
    private static void buildMaxHeap(int[] arr) {
        //最后一个父亲节点
        // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {   //下标为i的节点下标为（i-1）/2
            maxHeapify(arr, i, arr.length);
        }
    }
    // 调整大顶堆，第三个参数表示剩余未排序的数字的数量，也就是剩余堆的大小
    private static void maxHeapify(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int l = 2 * i + 1;
        // 右子结点下标
        int r = l + 1;
        // 记录根结点、左子树结点、右子树结点三者中的最大值下标
        int largest = i;
        // 与左子树结点比较
        if (l < heapSize && arr[l] > arr[largest]) { //这里l<=heapsize错的，因为交换元素到数组尾部arr.length - 1这里如果和尾部相等就需要维护整个尾部的长度，实际上是想要去掉尾部这个元素再来维护堆
            largest = l;
        }
        // 与右子树结点比较
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            // 将最大值交换为根结点
            swap(arr, i, largest);
            // 再次调整交换数字后的大顶堆
            maxHeapify(arr, largest, heapSize);//跑到左边或者右边节点下标去了，所以从那个下标开始继续递归
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

