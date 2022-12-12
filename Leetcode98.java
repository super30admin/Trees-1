import java.util.Stack;

public class Leetcode98 {

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
    public boolean isValidBST(TreeNode root) {
        // this pre order traversal, and in order to valid a binary tree is bst, if we
        // traverse the
        // the binary tree in inoder travel then we will get a incresing order and if
        // order get
        // distrub any time then its not a bst.
        // we will use iterative method of tree traversal, and with iterative method we
        // have to
        // use the stack.

        if (root == null)
            return false;

        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            System.out.print(root.val);
            root = root.right;
        }

        return true;
    }
}

// time complexity==O(n)
// space complexity==O(height of tree)