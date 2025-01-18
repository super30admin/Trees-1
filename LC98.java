/*
 * Approach 1:
 *     Time Complexity: O(n) : as we are visiting each node.
 *     Space Complexity: O(n) : as the stack space is O(n) in the worst case when tree is skewed.
 * 
 * Approach 2:
 *    Time Complexity: O(n) : as we are visiting each node.
 *    Space Complexity: O(n) : as the stack space is O(n) in the worst case when tree is skewed.
 * 
 * where n represents total number of nodes in a binary tree
 */

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

/*
 * Approach 1
 */
public class LC98 {
    private boolean recurse(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        int currVal = root.val;
        if ((max != null && currVal >= max) || (min != null && currVal <= min))
            return false;
        boolean l = recurse(root.left, min, currVal);
        boolean r = recurse(root.right, currVal, max);
        return l && r;
    }

    public boolean isValidBST(TreeNode root) {
        return recurse(root, null, null);
    }
}

/**
 * Approach 2
 */
class LC98_2 {
    private boolean recurse(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        int currVal = root.val;
        if (currVal >= max || currVal <= min)
            return false;
        boolean l = recurse(root.left, min, currVal);
        boolean r = recurse(root.right, currVal, max);
        return l && r;
    }

    public boolean isValidBST(TreeNode root) {
        return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}