//TC:O(n)
//SC: O(h) where h is height of BST

import java.util.Stack;

class TreeNode {
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

public class ValidateBinaryTree {
    TreeNode prev;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        //in order
        // left root right all elements in ascending order
        // or right root left

        // Pre Order
        // root left right or root right left

        //Post Order
        // Left right root
        // right left root
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        // to print in order
        // if(root == null) return;

        // helper(root.left);
        // System.out.println("UP " +root.val);
        // helper(root.right);
        // System.out.println("DOWN " +root.val); //to understand recursion
        if(root == null) return;

        helper(root.left);
        // System.out.println("UP " +root.val);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        helper(root.right);
        System.out.println("DOWN " +root.val);
    }
    public boolean isValidBST2(TreeNode root) {
        return helper2(root);
    }
    private boolean helper2(TreeNode root){
        if(root == null) return true;
        // boolean left = helper(root.left);
        if(!helper2(root.left)) return false;
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        boolean right = helper2(root.right);
        return right;
    }
    public boolean isValidBST3(TreeNode root) {
        // Iterative Approach
        TreeNode prev = null;
        Stack<TreeNode> st  = new Stack<>();
        boolean flag = true;

        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && prev.val >= root.val)
                return false;
            // System.out.println(root.val); //inorder traversal
            prev = root;
            root = root.right;
        }
        return flag;

    }
}
