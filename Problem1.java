class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);

        if(prev != null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);

    }
}
