package leetcode;

import java.util.*;

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] num = new int[m*n];
        num = PrintNumber(arr);
        String[] s = new String[num.length];
        for(int i = 0;i<num.length;i++){
            s[i]  =String.valueOf(num[i]);
        }

        System.out.print(Arrays.toString(s));
    }

    static int[] PrintNumber(int[][] matrix){
        if(matrix.length==0) return new int[]{};
        int m = matrix.length,n = matrix[0].length;
        int l = 0,r = n-1,up = 0,down = m-1,k = 0;
        int[] res = new int[m*n];
        while(true){
            for(int i =l;i<=r;i++){
                res[k++] = matrix[up][i];
            }
            if(++up>down) break;
            for(int i = up;i<=down;i++){
                res[k++] = matrix[i][r];
            }
            if(--r<l) break;
            for(int i = r;i>=l;i--){
                res[k++] = matrix[down][i];
            }
            if(--down<up) break;
            for(int i = down;i>=up;i--){
                res[k++] = matrix[i][l];
            }
            if(++l>r) break;
        }
        return res;

    }
}


