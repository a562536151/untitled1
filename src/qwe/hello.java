package qwe;

import java.util.*;
import java.lang.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char[][] grid = new char[a+1][b+1];
        for(int i = 0;i<a;i++){
            for(int j = 0;j<b;j++){
                grid[i][j] = (char) (sc.nextInt());
            }
        }
        int n = numlands(grid);
        System.out.print(n);
    }

    public static int numlands(char[][] grid){
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;i<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}