// Time Complexity : O(N)
// Space Complexity : O(H): H = height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ValidateBinarySearchTree {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        //base
        if(root == null) return  true;
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;

        //logic
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
