// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) where h is the height of the tree. it can be O(n) in case of skewed tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach

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
    TreeNode prev;
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root ==null)
            return true;
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null&&prev.val>=root.val){
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
    // public boolean isValidBST(TreeNode root){
    //     if(root ==null) return true;
    //     Stack<TreeNode> s = new Stack<>();
    //     while(root!=null || !s.isEmpty()){
    //         while(root!=null){
    //             s.push(root);
    //             root = root.left;
    //         }
    //         root = s.pop();
    //         if(prev !=null && prev.val>= root.val)
    //             return false;
    //         prev = root;
    //         root = root.right;
    //     }
    //     return true;
    // }
}