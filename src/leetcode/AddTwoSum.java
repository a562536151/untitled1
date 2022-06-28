package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class AddTwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s =  sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i = 0;i<s.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);


    }
}
