package leetcode;

import qwe.Merge;

import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i = 0;i<s.length;i++){
            arr[i]  = Integer.parseInt(s[i]);
        }
        merge(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    private static void merge(int[] arr) {
        int[] second = new int[arr.length];
        merges(arr,second,0,arr.length-1);
    }

    private static void merges(int[] arr, int[] second, int start, int end) {
        if(start==end) return;
        int mid = (start+end)/2;
        merges(arr,second,start,mid);
        merges(arr,second,mid+1,end);
        Merge(arr,second,start,end);
    }

    private static void Merge(int[] arr,int[] second,int start,int end){
        int mid = (start+end)/2;
        int s1 = start;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = end;
        int begin = start;
        while (s1<=e1&&s2<=e2){
            if(arr[s1]>arr[s2]){
                second[begin++] = arr[s2++];
            }
            else second[begin++] = arr[s1++];
        }
        while(s1<=e1){
            second[begin++] = arr[s1++];
        }
        while (s2<=e2){
            second[begin++] = arr[s2++];
        }
        for(int i = start;i<=end;i++){
            arr[i]  = second[i];
        }
    }
}
