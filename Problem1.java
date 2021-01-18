Time Complexity: O(n). n is nodes in tree
Space Complexity: O(1) + recursive stack space O(H). H is height of BST.
Ran successfully on leetcode?: yes

class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root){
        if(root == null) return true;
        
        if(!(inorder(root.left))) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        return inorder(root.right);
    }
}
