// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
class ValidateBST {
    public class TreeNode {
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

    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        // base condition
        if (root == null)
            return true;
        if (inorder(root.left) == false)
            return false;
        if (prev != null && prev.val >= root.val)
            return false;
        System.out.println(root.val);
        prev = root;
        return inorder(root.right);
    }
}
