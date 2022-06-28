package qwe;

import java.util.Arrays;

import static qwe.Heap.heapSort;

public class Heaps {
    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 11, 1, 2, 3, 6, 1, 6, 2};
        heapSort(a);
        System.out.println(Arrays.toString(a));//System.out.print(Arrays.deepToString(gameboardTwo));二维用这个
    }
    public static void heapSort(int[] arr){
        buildHead(arr);
        for(int i  = arr.length;i>=0;i--){
            swap(arr,i,0);

        }
    }

    private static void buildHead(int[] arr) {
        for(int i = arr.length/2-1;i>=0;i--){
            Heapityfy(arr,i,arr.length);
        }
    }

    private static void Heapityfy(int[] arr,int i,int end) {
        int left = 2*i+1;
        int right = 2*i+2;
        int start = left;

    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
