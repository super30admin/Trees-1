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
//The solution is void based recursion
//we start with -inf, to +inf with root node
//for the left tree node will be in between -inf to node.val
//right tree +inf to node.val
//we update min and max range for each node
//Time complexity O(n)
//space complexity O(h) stack for recurion
class Solution {
    boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return isValid;
    }

    public void helper(TreeNode node, long minVal, long maxVal)
    {
        //base
        if(node==null)
        {
            return;
        }
        //logic
        if(!(node.val>minVal && node.val<maxVal))
        {
            isValid = false;
            return;
        }
        helper(node.left,minVal,node.val);
        helper(node.right,node.val, maxVal);
    }
}