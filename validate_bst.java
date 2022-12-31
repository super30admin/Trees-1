// Time Complexity : O(n)
// Space Complexity : O(h) - height of the recursive stack
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
    // public boolean isValidBST(TreeNode root) {
    //     inorder(root);
    //     return true; 
    // }
    // private void inorder(TreeNode root){
    //     if(root==null) return;

    //     inorder(root.left);
    //     // st.pop() under the hood
    //     System.out.print("up");
    //     System.out.println(root.val);
    //     inorder(root.right);
    //     // st.pop() under the hood
    //     System.out.print("down");
    //     System.out.println(root.val);
    // }

    // // Using Recurssion, where there is no control using the flag
    // TreeNode prev;
    // boolean flag;
    //  public boolean isValidBST(TreeNode root) {
    //     flag = true;
    //     inorder(root);
    //     return flag; 
    // }
    // private void inorder(TreeNode root){
    //     if(root==null) return;
    //     inorder(root.left);
    //     // st.pop() under the hood
    //     if(prev!=null && prev.val>=root.val){
    //         flag = false;
    //     }
    //     prev = root;
    //     inorder(root.right);
    //     // st.pop() under the hood
    // }
    // Using Recurssion void method, where there is control using the flag
    // TreeNode prev;
    // boolean flag;
    //  public boolean isValidBST(TreeNode root) {
    //     flag = true;
    //     inorder(root);
    //     return flag; 
    // }
    // private void inorder(TreeNode root){
    //     if(root==null) return;
    //     if(flag){
    //         inorder(root.left);
    //     }
    //     // st.pop() under the hood
    //     if(prev!=null && prev.val>=root.val){
    //         flag = false;
    //     }
    //     prev = root;
    //     if(flag)
    //         inorder(root.right);
    //     // st.pop() under the hood
    // }

    // Using Recurssion boolean method, if you pass prev as local variable
    // the values will be overwritten
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    private boolean inorder(TreeNode root){
        if(root==null) return true;
        if( inorder(root.left) ==  false) return false;
        // st.pop() under the hood
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        prev = root;
        return inorder(root.right);
        // st.pop() under the hood
    }
}