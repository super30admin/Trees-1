class Solution {
    boolean isValid = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) { 
        if(root == null){
            return isValid;
        }
        inorder(root);
        return isValid;
       
    }
    void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prev!= null && prev.val >= root.val){
            isValid =false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
