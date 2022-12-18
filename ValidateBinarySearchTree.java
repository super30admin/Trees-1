//Time Complexity: O(n)
//Space Complexity: O(h) height of the tree
/*
 * call a recursive function on root's left and right node while maintaining a prev
 * pointer. if the current value is less than prev we return false and end the code.
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
class ValidateBinarySearchTree{
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        return helper(root);
    }

    public boolean helper(TreeNode root){
        if(root == null || flag == false) return false;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        helper(root.right);
        return flag;
    }
}