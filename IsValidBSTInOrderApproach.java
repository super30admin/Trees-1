// Approach: We are basically doing an inorder traversal and have 2 nodes at any give time prev and root and we have to keep checking if they are in sorted order where prev should be less than root's value. So we can only use inorder to check if the tree is sorted

// Time complexity: O(n)
// Space complexity: O(h) where h is the height of the tree 
// As maximum number of elements on the stack the height of the tree at any given time

// Void Approach

class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        if(flag) inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        if(flag) inorder(root.right);
    }
}

// Boolean approach

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) return true;
        boolean left = inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean right = inorder(root.right);
        return left && right;
    }
}