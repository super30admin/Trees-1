// Time Complexity : o(n) where n is the number of nodes in the BST
// Space Complexity : o(h) where h is the height of the BST
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
    /* Traverse all the nodes in the BST and check if the node val is > left.val and node.val < right.val
    Use recursion traverse in a DFS first through all of left and validate and all of right and validate.
*/
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
    public boolean isValidBST(TreeNode root) {
        //the lower and upper limits to the value of the root node to be compared to would be null.
        return validate(root, null, null);
    
    }
    public boolean validate(TreeNode node, Integer low, Integer high){
        //leaf node demarks the end of traversal
        if(node == null){
            return true;
        }
        //if the node value is lesser than its left node value and greater than its right node value, then its not a valid BST. SO return false.
        if((low!=null && node.val<=low) || (high!=null && node.val>=high)){
            return false;
        }

        //traverse each left node and each right node (DFS) and valiate for each node through recursion
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}