package Nov4;

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

class ValidateBSTRecursive {
    
    TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
         
        // base condition for recursion
        if (root == null) {
            return true;
        }
        
        // if left subtree is not valid BST, no point of checking for right subtree, so return false from here itself.
        if (!isValidBST(root.left)) {
            return false;
        }
        // st.pop(); Analogous to iterative approach using stack (Check previous submission on this problem).
        
// prev node should ideally be < root node value for a valid BST because we are iterating inorder, and prev is one step behind current node, so it will ideally be less than root node val for the given tree to be a valid BST.If not, we can return false from here itself.
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        
        // Analogous to iterative approach using stack (Check previous submission on this problem).
        prev = root;
        return isValidBST(root.right);
        
    }
       
}