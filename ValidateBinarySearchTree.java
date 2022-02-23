import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Time Complexity: O(n)
Space Complexity: O(n)
Run on leetcode: yes
Any difficulties: no

Approach:
1. Using recursion and comparing left node values to root val and right node values to root val
2. In case where the left root values are less than root val and right root values are greater than the root val
returning true
 */
public class ValidateBinarySearchTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right= right;
        }
    }

    public static boolean validateBinarySearchTree(TreeNode root){
        return isBST(root, null, null);
    }
    public static boolean isBST(TreeNode root, Integer low, Integer high){
        if(root == null){
            return true;
        }

        if((low!= null && root.val <=low) || (high!= null && root.val>=high)){
            return false;
        }
        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(validateBinarySearchTree(root));
    }
}
