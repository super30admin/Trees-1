// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Gone through the lecture again to work on the solutions and mistakes.

// https://leetcode.com/problems/validate-binary-search-tree

//Valid BST 2.1
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
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);
    }
    
}
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this

// https://leetcode.com/problems/validate-binary-search-tree

//Valid BST 2.0

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
        if(min != null && root.val<=min){
            return false;
        }
        if(max != null && root.val>=max){
            return false;
        }
        
        boolean left = helper(root.left, min, root.val);
        if(left == false) return false;
        boolean right = helper(root.right, root.val, max);
        return right;
        
    }
    
}