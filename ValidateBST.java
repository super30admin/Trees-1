
public class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return this.flag;
    }

    private void inorder(TreeNode root){
        if(root == null || this.flag == false) return;
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
            this.flag = false;
        }
        prev = root;
        inorder(root.right);
    }
}
