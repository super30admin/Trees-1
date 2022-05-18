import javax.swing.tree.TreeNode;

// Time Complexity : O(n) traversed entire BST (right most leaf)
// Space Complexity : O(n) run timestack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class Solution {
    private Integer prev;
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if (root == null){ // made it to end of branch w/o returning false
            return true;
        }
        
        if (!inorder(root.left)){ // inorder traversal --> go to left most node
            return false;
        }
        
        if (prev != null && root.val <= prev){ // does not respect rule of BST
            return false;
        }
        
        prev = root.val;
        return inorder(root.right);
    }
}