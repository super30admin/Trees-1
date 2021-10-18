// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//we use recursion here..the recursive functio is called for left and right subtrees..if any tree is invalid
//it throws false.. the values start from null as we dnt have specific range..nulll values wont be 
//compared..they would be considered to hve anything smaller and greater than thse values
//as recursive tree grows the high and low values will go on changing

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
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode node, Integer low, Integer high){
        if(node==null){
            return true;
        }
        if((low!=null && node.val<= low) || (high!=null && node.val>=high)){
            return false;
        }
        
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}