// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
For the given binary tree we perform a inorder traversal and check if the nodes values are in increasing order
We take prev and current pointers and of previous value is greater than current roots value then its a breach and not a valid BST
Recursion ends when root is null
*/

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag; 
    }

    private void inorder(TreeNode root) {

        //base
        if (root == null || !flag) return;
       
        inorder(root.left);

        if(prev!=null && root.val <= prev.val) {
            flag = false;
        }
        prev = root;


        inorder(root.right);

    }
}
