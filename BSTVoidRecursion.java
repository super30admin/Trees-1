// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Using void based recursion to validate BST and update flag if its not valid BST

// Your code here along with comments explaining your approach

public class BSTVoidRecursion {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if (root == null || flag == false) return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            flag = false;
        }
        prev = root;
        inorder(root.right);
    }
}
