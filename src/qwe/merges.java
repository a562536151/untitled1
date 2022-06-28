package qwe;

import java.util.Arrays;

public class merges {
    public static void main(String[] args) {
        int[] arr = new int[]{6,3,8,2,1};
        mergeSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 0) return;
        int[] result = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, result);
    }

    // 对 arr 的 [start, end] 区间归并排序
    private static void mergeSort(int[] arr, int start, int end, int[] result) {
        // 只剩下一个数字，停止拆分
        if (start == end) return;
        int middle = (start + end) / 2;
        // 拆分左边区域，并将归并排序的结果保存到 result 的 [start, middle] 区间
        mergeSort(arr, start, middle, result);
        // 拆分右边区域，并将归并排序的结果保存到 result 的 [middle + 1, end] 区间
        mergeSort(arr, middle + 1, end, result);
        // 合并左右区域到 result 的 [start, end]
        merge(arr, start, end, result);
    }

    // 将 result 的 [start, middle] 和 [middle + 1, end] 区间合并
    private static void merge(int[] arr, int start,  int end, int[] result) {
        int middle = (start + end) / 2;
        // 数组 1 的首尾位置
        int start1 = start;
        int end1 = middle;
        // 数组 2 的首尾位置
        int start2 = middle + 1;
        int end2 = end;
        // 用来遍历数组的指针
        // 结果数组的指针
        int resultIndex = start1;
        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] <= arr[start2]) {
                result[resultIndex++] = arr[start1++]; //每次这里忘了++
            } else {
                result[resultIndex++] = arr[start2++];
            }
        }
        // 将剩余数字补到结果数组之后
        while (start1 <= end1) {
            result[resultIndex++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[resultIndex++] = arr[start2++];
        }
        // 将 result 操作区间的数字拷贝到 arr 数组中，以便下次比较
        for (int i = start; i <= end; i++) {
            arr[i] = result[i];
        }
    }

}
