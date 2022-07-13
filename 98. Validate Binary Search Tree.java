//Time Complexity: O(n)
//Space Complexity: O(height of tree)
//Recursion Method
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
        }
        prev = root;
        inorder(root.right);
    }
}