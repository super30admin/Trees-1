/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(logn)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsValidBST {
    boolean result = true;
    TreeNode prev = null;
    Stack<TreeNode> stack = new Stack<>();

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val)
                result = false;
            prev = root;
            root = root.right;
        }
    }
}