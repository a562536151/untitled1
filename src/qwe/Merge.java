package qwe;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,3,1,6,7};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesort(int[] arr) {
        int[] a = new int[arr.length];
        merge(arr,a,0,arr.length-1);
    }

    private static void merge(int[] arr, int[] a, int start, int end) {
        if(start==end) return;
        int mid = (start+end)/2;
        merge(arr,a,start,mid);
        merge(arr,a,mid+1,end);
        mergesorts(arr,a,start,end);
    }

    private static void mergesorts(int[] arr, int[] a, int start, int end) {
        int mid = (start+end)/2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid+1;
        int end2 = end;
        int len = start;
        while(start1<=end1&&start2<=end2){
            if(arr[start1]>=arr[start2]){
                a[len++] = arr[start2++];
            }
            else{
                a[len++] = arr[start1++];
            }
        }
        while(start1<=end1){
            a[len++] = arr[start1++];
        }
        while(start2<=end2){
            a[len++] = arr[start2++];
        }

        for(int i = start;i<=end;i++){
            arr[i] = a[i];
        }
    }
}
