import java.util.Stack;

// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class ValidateBSTIterative {
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

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            // inorder(root.left)
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            // st.pop()
            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            // inorder(root.left)
            root = root.right;
        }
        return true;
    }
}
