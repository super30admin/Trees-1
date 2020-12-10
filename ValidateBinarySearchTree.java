/* Time Complexity = O(N)
/* Space Complexity = O(N)
/* Idea - Inorder is sorted so prev node must be strictly less that 
// root value.
*/

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
    
    public boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left);
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        prev = root;
        boolean right = helper(root.right);
        return left && right;
    }
}

/* Solution 2
/*
/* Time Complexity = O(N)
/* Space Complexity = O(N)
/* Idea - Left values are upper bounded by root value
// and right values are lower bounded by root value in a BST.
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
        return helper(root,null,null);
    }
    
    private boolean helper(TreeNode root,Integer min,Integer max){
        if(root == null){
            return true;
        }
        if((min != null && root.val<=min
) || (max != null && root.val>=max)){
            return false;
        }
           return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }
}