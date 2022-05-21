// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode previous;
    private boolean isValid;
    public boolean isValidBST(TreeNode root) {
        previous = null;
        isValid = true;
        inorderTraversal(root);
        return isValid;
    }
    private void inorderTraversal(TreeNode root){
        if(!isValid || root == null) return;
        inorderTraversal(root.left);
        if(previous != null && previous.val >= root.val)
            isValid = false;
        previous = root;
        inorderTraversal(root.right);
    }
}