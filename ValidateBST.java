// Time Complexity : O(n) where 'n' is the number of nodes.
// Space Complexity : O(h) where 'h' is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach:
Do inorder traversal of the tree
go towards left and store the node in prev
any value to the left should not be greater than the current, if so return false
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

//Approach - 1: Normal conditional check and inorder traversal
class ValidateBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
        
    }
    private boolean helper( TreeNode root){
        if (root == null) return true;
        if (helper(root.left) == false) return false;
        //breach check
        if(prev != null && prev.val >=root.val){
            return false;
        }
        prev = root;
        return (helper(root.right));
    }
}

//Approach 2: using min and max for each root value, it gives us a range in which a node can lie
// if there is a breach we return false
class ValidateBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
        
    }
    private boolean helper( TreeNode root, Integer min, Integer max){
        if (root == null) return true;
        if ((min != null && min >= root.val) || (max != null && max <= root.val)){
            return false;
        }
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
       return left&&right;
    }
}