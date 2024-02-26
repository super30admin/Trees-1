// Time Complexity: O(n)
// Space Complexity: O(n)

public class ValidateBST {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        //base
        if(root == null) return;
        //logic
        inorder(root.left);
        if(prev != null && prev.val >= root.val){
            this.flag = false;
        }
        prev =root;
        inorder(root.right);
    }
}
