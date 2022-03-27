// Time Complexity : O(n) , n= no. of nodes
// Space Complexity : O(h)  ; h= height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//using min ,max method for every node 
//1. for left child, min->same , max-> till root value.
//2. for right child, max->same , min-> till root value.

//If the min value at a node is greater than the root value we make flag as false.
//If the max value at a node is less than root value then we make flag as false.
//and when root becomes null we return.


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
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root,null,null);
        return flag;
    }
    
    private void helper(TreeNode root , Integer min , Integer max){
        //base
        if(root==null){
            return;
        }
        if(min != null && min >= root.val){
            flag = false;
            return;
        }
        if(max != null && max <= root.val){
            flag = false;
        }
        
        //logic
        helper(root.left,min,root.val);
        helper(root.right , root.val,max);
    }
}