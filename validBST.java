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
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
  
private boolean helper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        
        return root.val > min && root.val < max
            && helper(root.left, min, root.val) 
            && helper(root.right, root.val, max); 
}
}


//SC: O(n) recursion stack space -> is this correct
//TC:O(n)
//Accpted on leetcode/
//Using min and max and comapring each node with min and max
