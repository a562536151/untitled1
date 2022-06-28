package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
            TreeNode left;
            TreeNode right;
            int val;
        public TreeNode(int val){
        this.val = val;
        }
        }


public class Tree {


    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        TreeNode root = buildTree(arr);
        int depth = countDepth(root);
        int min = minDepth(root);
        System.out.println(depth);
    }

    private static int minDepth(TreeNode root) {
        return 0;
    }

    private static int countDepth(TreeNode root) {
        if(root==null) return 0;
        int l = countDepth(root.left);
        int r = countDepth(root.right);

        return Math.max(l,r)+1;
    }



    private static TreeNode buildTree(int[] arr) {
        List<TreeNode> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            TreeNode a = new TreeNode(arr[i]);
            list.add(a);
        }
        TreeNode root;
        for(int i = 0;i<arr.length/2;i++){
            root = list.get(i);
            root.left = list.get(2*i+1);
            root.right = list.get(2*i+2);
        }
        return list.get(0);
    }
}
