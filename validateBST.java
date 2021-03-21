//TC: O(n)
//SC: O(n) -> recurrsion Stack - (number of nodes instead say:---->) height of the tree
//Leetcode: Siccess
//Problem: Still new to the concept and python version is difficult to grasp!
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
        return validate(root, null, null);
    }
    //Recursion
    private boolean validate(TreeNode node, Integer low, Integer high){
        // Check Node
        if(node==null){
            return true;
        }

        //Check Node Value
        if((low!=null && node.val<=low) || (high!=null && node.val>=high)){
            return false;
        }
        // Check LS & RS
        return validate(node.left,low,node.val) && validate(node.right,node.val,high);
    }
}
