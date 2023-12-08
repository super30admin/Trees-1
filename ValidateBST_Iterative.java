// Time Complexity : O(h) //h is height of the tree
// Space Complexity : O(h) // h being stack space used in iterative call
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

import java.util.Stack;

// Used recursive approach to validate the values of root with its left and right sub trees
public class ValidateBST_Iterative {
    public boolean isValid(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> st = new Stack();
        TreeNode prev = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && root.val <= prev.val) return false;
            prev = root;
            root = root.right;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode  tl = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode  tr = new TreeNode(6, new TreeNode(5), new TreeNode(7));
        TreeNode  t = new TreeNode(8, tl, tr);
        boolean res = new ValidateBST_Iterative().isValid(t);
        System.out.println(res);
    }

}