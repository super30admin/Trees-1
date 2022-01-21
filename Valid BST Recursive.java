// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        // call the recursive function
        inorder(root);
        return flag;
    }
    
    private void inorder(TreeNode root){
        // base condition
        if(root == null)  return;
        
        // keep pushing the left elements inside the recursive stack
        inorder(root.left);
        
        // recursive stack pop - st.pop();
        
        // System.out.print(root.val + " ");
        
        // check with previous root value
        if(prev != null && prev.val >= root.val){
            // return false if current root is less than or equal to the previous root
            flag  = false; 
        }
        
        // update previous root
        prev = root;
        
        // keep pushing the right elements inside the recursive stack
        inorder(root.right);
        //st.pop();
    }
}