//TC - O(n) where n is number of nodes in a tree.
//SC - O(h) where h is the height of the tree.

class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        isValid = true;
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            isValid = false;
            return;
        } 
        prev = root;
        inorder(root.right);
    }
}
