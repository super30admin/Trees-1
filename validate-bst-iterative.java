import java.util.*;

//Time Complexity is O(n) where n is number of nodes
//Space Complexity is O(h) where h is height of tree -> in this case it can be n as max height (only if balanced tree height can be logn)
class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }

        return true;

    }
}
