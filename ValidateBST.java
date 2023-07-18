import javax.swing.tree.TreeNode;

class ValidateBST{
    TreeNode prevNode;
    boolean isValid;
    public boolean isValidBST(TreeNode root){
        this.isValid = true;
        inorder(root);
        return this.isValid;
    }

    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(prevNode != null && prevNode.val >= root.val){
            this.isValid = false;
        }
        prevNode = root;
        inorder(root.right);
    }

}