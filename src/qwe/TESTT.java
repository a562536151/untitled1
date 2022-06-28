package qwe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TESTT {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,1,3,2};
        quicksortss(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

   static void quicksortss(int[] arr,int l,int r){
        if(l>=r) return;
        int i = l,j =r;
        while(i<j){
            while(i<j&&arr[j]>=arr[l]) j--;
            while(i<j&&arr[i]<=arr[l]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,l);
        quicksortss(arr,l,i-1);
        quicksortss(arr,i+1,r);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
