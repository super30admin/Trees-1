//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes

public class ValidateBinarySearchTree {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        inorder(root);
        return isValid;
    }

    public void inorder(TreeNode root) {
        //base
        if(root == null) return;
        inorder(root.left);
        //breach
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
