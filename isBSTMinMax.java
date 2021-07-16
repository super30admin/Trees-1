// Time Complexity : O(N)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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

//recursive approach using min and max 
class Solution {
    
    boolean result;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        //set result to true initially
        result = true;
        //root, min, max
        inorder(root, null, null);
        return result;
    }
    
    private void inorder(TreeNode root, Integer min, Integer max){
        
        //base
        if(root == null)
            return;
        //left
        inorder(root.left, min, root.val);
        //root & check if BST or not 
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            result = false;
            return;
        }
        //right
        inorder(root.right, root.val, max);
    }
}