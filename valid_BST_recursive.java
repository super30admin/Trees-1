// Time Complexity : O(n) : Traversing the every node once
// Space Complexity : O(n) : Recursive Stack

class Solution {
    // Must be global as recursive call of inorder will update the prev if we store it as function argument
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        
        // Inorder Traversal + Checking Sorted or not : Valid BST
        return inorder(root);    
    }
    
    
    // Recursion
    private boolean inorder(TreeNode root){
        
        if (root == null) {
            return true;
        }
        
        // LNR 
        // left sub tree
        boolean leftans  = inorder(root.left);
        
        // Check if left subtree is invalid BST
        if (leftans == false){
            return false;
        }
        
        // node
        
        if (prev != null && prev.val >=  root.val){
            return false;
        }
        
        // Update for the next recursion
        prev = root;
        
        // right subtree
        boolean rightans = inorder(root.right);
        
        return rightans;
    }
}