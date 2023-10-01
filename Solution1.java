//Leetcode Problem : https://leetcode.com/problems/validate-binary-search-tree/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * Property of binary search tree - A node should always be greater than it's left child and smaller than it's right 
 * child. I pass the root and null values for min and max to the check function initially. In the check fn, if root
 * equals null, I return true. If min is not null and root.val is less than or equal to min or max is not null and
 * root.val is greater than or equal to max, I return false. I recursively call check(root.left,min,root.val) && 
 * check(root.right,root.val,max). While checking the left subtree, I ensure that root.val is the maximum value
 * and while checking the right subtree, I ensure that root.val is the minimum value.
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
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }

    public boolean check(TreeNode root, Integer min, Integer max)
    {
        if(root==null)
        {
            return true;
        }
        if((min!=null && root.val<=min) ||  (max!=null && root.val>=max))
        {
            return false;
        }
        return check(root.left,min,root.val) && check(root.right,root.val,max);
    }
}