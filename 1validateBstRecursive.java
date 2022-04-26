// observe how we used global variables prev, isValid
// this is to keep track of prev and isValid globally since we make frequent calls to recursive stack if we pass the values locally
// we will lose track of actual prev value 
// its crucial for prev pointer to be global
//TC: O(N) SC: O(H) H -> height of tree

class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        inorder(root);
        return isValid;
    }
    private void inorder(TreeNode root) { // this return type is void, i've also attempted with boolean return type
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
        
    }
}