// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// When we move left of root, check if the value is in range of current minimum and root value.
// When we move right of root, check if the value is in range of root value and current max.

// Your code here along with comments explaining your approach

public class BSTWithMinMax {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if (max != null && max <= root.val) return false;
        if (min != null && min >= root.val) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
