import java.util.*;

class Solution {
    //Iterative Solution
    // Time complexity is O(n)
    // Space complexity is O(h) i.e height of the tree
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
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        helper(root);
        return isValid;
    }
    private void helper(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || !st.empty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!= null && prev.val>= root.val){
                isValid = false;
                return;
            } 
            prev = root; // we need to set prev to root
            if(isValid)
                root = root.right;
        }
    }
}