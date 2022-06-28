package qwe;

import java.util.Scanner;

public class insertsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i = 0;i<arr.length;i++){
            arr[i]  = Integer.parseInt(s[i]);
        }
        insertsorts(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    private static void insertsorts(int[] arr) {
        for(int i = 1;i<arr.length;i++){
                int j = i;
                while (j>=1&&arr[j]<arr[j-1]){
                    swap(arr,j-1,j);
                    j--;
                }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
     }


}
