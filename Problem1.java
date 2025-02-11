import javax.swing.tree.TreeNode;

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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
        
    }

    private boolean inOrder(TreeNode root){
        if(root == null) return true;
        boolean left = inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        boolean right = true;
        if(left){
             right = inOrder(root.right);
        }

        return left && right;
    }
}