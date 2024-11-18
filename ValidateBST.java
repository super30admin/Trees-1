public class ValidateBST {

    /**
     * Time complexity - O(n) -> n is the number of nodes in the tree
     * Space Complexity - O(1)
     * Logic: Have a global previous node, do a inorder tree traversal recursively and
     *        assign the prev node to root if prev is not null and prev.val >= root.val in which case
     *        it will be a invalid bst, we will return false and exit from the function call. if we complete the
     *        left and right subtree traversal without hitting the above condition we can return the boolean value of
     *        left and right subtree
     *
     */
    public class TreeNode {
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
    class Solution {
        TreeNode previous;

        public boolean isValidBST(TreeNode root) {
            return helper(root);
        }

        public boolean helper(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean left = helper(root.left);
            if (previous != null && previous.val >= root.val) {
                return false;
            }
            previous = root;
            boolean right = helper(root.right);
            return left && right;
        }
    }
}
