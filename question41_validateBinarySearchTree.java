package Trees1;

import java.util.Stack;

public class question41_validateBinarySearchTree {

    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     /*
        Iterative Approch:
            Time Complexity: O(n); since we are touching each and every node
            Space Complexity: O(h); h - height of the tree
      */
    public boolean isValidBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            if(prev != null && prev.val >= root.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }

    /*
        Time Complexity: O(n); since we are touching each and every node
        Space Complexity: O(h); h - height of the tree
     */
    TreeNode prev;
    public boolean isValidBSTOptimizied(TreeNode root) {
        return inorderTraversal(root);
    }

    private boolean inorderTraversal(TreeNode root) {
        if(root == null) return true;

        if(inorderTraversal(root.left) == false) return false;

        if(prev != null && prev.val >= root.val) return false;
        prev = root;

        return inorderTraversal(root.right);
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(h); h - height of the tree
     */
    public boolean isValidBSTOptimized(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max) {
        // Base Case
        if(root == null) return true;
        if(min != null && root.val <=  min) return false;
        if(max != null && root.val >=  max) return false;

        //Logic
        // boolean case1 = helper(root.left, min, root.val);
        // stack.pop() is occuring under the hood
        // if(case1 == false) return false;
        // boolean case2 = helper(root.right, root.val, max);

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /*
        Time Complexity: O(n)
        Space Complexity: O(h); h - height of the tree
     */
    boolean result;
    public boolean isValidBSTOpt(TreeNode root) {
        result = true;
        helper1(root, null, null);
        return result;
    }
    private void helper1(TreeNode root, Integer min, Integer max) {
        // Base Case
        if (root == null) return;
        if (min != null && root.val <= min) {
            result = false;
            return;
        }
        if (max != null && root.val >= max) {
            result = false;
            return;
        }

        //Logic
        helper1(root.left, min, root.val);
        // stack.pop() is occuring under the hood
        // if(result == false) return;
        helper1(root.right, root.val, max);

        return;
    }
    public static void main(String[] args) {

    }
}