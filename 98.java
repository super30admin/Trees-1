/**Algorithm : For recursion
left.val < node.val
right.val > node.val

if any is not valid -> return false else return true at end.

TC - O(n)
SC - O(n) the recursion stack
where n is each node.

NOTE - int cannot have null but Integer can have null.
**/


//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


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
        return validate(root,null,null);
    }
    
    private boolean validate(TreeNode node, Integer low, Integer high){
        //Check Node
        if(node == null) return true;
        
        //Check Node Value
        if(( low != null && node.val <= low ) || (high != null && node.val >= high)){
            return false;
        }
            
        return validate(node.left,low,node.val) && validate(node.right, node.val, high);
    }
}