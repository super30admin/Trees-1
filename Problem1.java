// Time Complexity : O(n) as it will traverse each node of the tree
// Space Complexity : O(h) space of recursive stack which stores node for all recursive calls
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode prev = null;
        return inorder(root);
    }

    public boolean inorder(TreeNode root){
        if(root == null){
            return true;
        }

        boolean isValidLeft = inorder(root.left);
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        boolean isValidRight = inorder(root.right);

        return isValidLeft && isValidRight;
    }
}
