// S30 Big N Problem #40 {Medium}
// 98. Validate Binary Search Tree
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isBST(TreeNode node, long min, long max){
        if(node==null) return true;
        
        if(node.val<=min || node.val>=max){
            return false;
        }
        else{
            return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);    
        }
    }
}