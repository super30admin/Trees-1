
// Time Complexity : O(N)
// Space Complexity : O(h) : height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
/*Approach
1) we consider to use the approach of using null values as -infinity and +infinity
2) idea behind that is to set the bounds for the tree, as the value should not exceed the bounds
3) Thus while travelling the left sub tree, we aim to set max limit as root.val and min bound can be -Infinity, same applies while travelling to the right side
4) This way we can have a condition of min and max > root.val and checking and returning false
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
        
        if(root==null)
            return true;
        
        return inorder(root,null,null); // assigning null values 
    }
    
    public boolean inorder(TreeNode root,Integer min, Integer max)
    {
        if(root==null)
            return true;
        
        if(inorder(root.left,min,root.val)==false)
        {
            return false;
        }
        
        
        if((min!=null && min>=root.val)||(max!=null && max<=root.val))
        {
            return false;
        }
        
        
        return inorder(root.right,root.val,max);
    }
    
   
}