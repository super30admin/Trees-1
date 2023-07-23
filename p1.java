// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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

    //In inorder traversal, the prev value is always less than the next value in a bst
    //Using global variable previous node and flag if we find bst is not valid, make flag as false
    TreeNode prev = null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        bst(root);
        return flag;
    }

    public void bst(TreeNode root){
//Base condiiton
// When node is null, return
        if(root == null) return;
        
//Left node recursion
        if(flag){
            bst(root.left);
        }

        if(prev != null && prev.val>=root.val) flag = false;
        prev = root;
        
//Right node recurison
        if(flag){
            bst(root.right);
        }

    }
}