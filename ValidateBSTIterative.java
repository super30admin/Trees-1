package Trees1;
// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import java.util.Stack;

// Your code here along with comments explaining your approach
public class ValidateBSTIterative {
    public boolean isValidBST(TreeNode root){
        boolean flag = true;
        TreeNode prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()) {
            while (root != null) {
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            if (prev != null && prev.val >= root.val) {
                flag = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return flag;
    }
}
