// https://leetcode.com/problems/validate-binary-search-tree/

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, a helper is used as recursive function with root, min, max as parameters. When the root is null, it means the tree has reached till 
 * the end of the leaf and returns true for that recursive stack call. Here, main condition is that the value must lie between min and max.
 * For left tree it must be between -infinity and the root value and for right tree it must be between the root value and infinity. The value
 * of left and right gives whether the tree is a valid BST.
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
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;

        if(max!= null && max<= root.val){
            return false;
        }
        if(min!=null && min>=root.val){
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    
}