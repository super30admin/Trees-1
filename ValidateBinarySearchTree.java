
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
 * Valid BST when treversed in in-order; it must be sorted i.e., the left/prev
 * element in array should be less than the current.
 * so if left/prev value is greater than the current/root value then its not a
 * valid BST.
 */

public class ValidateBinarySearchTree {
    TreeNode prev = null;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return result;
    }

    // INORDER -> using global result
    private void helper(TreeNode root) {
        if (root == null)
            return;
        if (result)
            helper(root.left);
        if (prev != null && prev.val >= root.val) {
            result = false;
        }
        prev = root;
        if (result)
            helper(root.right);

    }

    //INORDER -> boolean return 
    /*
     * base case returns true.. i.e., at the base BST is valid.
     * if prev.val >= root.val -> return false;
     * if at any point the leftResult returns false return false.
     */

    private boolean helper2(TreeNode root){
        if(root==null) return true;
        boolean leftResult= helper2(root.left);
        if((prev!=null && prev.val >= root.val) || !leftResult){
            return false;
        }
        prev=root;
       return helper2(root.right);

    }
}
