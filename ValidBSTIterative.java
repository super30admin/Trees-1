package Trees1;

import java.util.Stack;

/*      Time complexity : o(m+n) 
        space complexity: o(1) 
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class ValidBSTIterative {

    TreeNode prev;

    public boolean isValidBSTWithIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) //left recursive call
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev.val >= root.val)
                return false;

            prev = root;
            root = root.right;
        }

        return true;
    }

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

}
