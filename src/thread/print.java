package thread;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

public class print {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        int[] b= new int[a.length];
        for(int i = 0;i<a.length;i++){
            b[i] = Integer.parseInt(a[i]);
        }
        TreeNode root = new TreeNode(b[0]);
        int c = maxDepth(root);
    }

    public static int maxDepth(TreeNode root){
        if(root==null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }


}


