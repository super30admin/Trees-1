// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//used recursion to go through everynode by using inorder traversal and checking if every node checked using 
//inorder traversal is greater than previous
//as inorder gives nodes of bst in ascending order.
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
    TreeNode previous;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        helper(root);
        return flag;
    }
    private void helper(TreeNode root){
        //base
        if(root == null) return ;
        //logic
        if(flag)helper(root.left);
        if(previous !=null && previous.val >= root.val) flag=false;
        previous = root;
        if(flag) helper(root.right);
    }
}