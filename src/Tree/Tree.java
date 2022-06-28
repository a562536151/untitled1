package Tree;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}

public class Tree {
    public TreeNode CreateTree(int[] a){
        List<TreeNode> list = new LinkedList<>();
        for(int i = 0;i<a.length;i++){
            TreeNode node = new TreeNode(a[i]);
            list.add(node);
        }
        TreeNode root;
        for(int i = 0;i<list.size()/2;i++){
            root = list.get(i);
            root.left = list.get(2*i+1);
            root.right = list.get(2*i+2);
        }
        return list.get(0);
    }

    public void PreOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] a = new int[]{2,3,5,1,7};
        TreeNode root = tree.CreateTree(a);
        tree.PreOrder(root);
    }
}
