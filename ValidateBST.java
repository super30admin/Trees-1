import javax.swing.tree.TreeNode;

//Time Complexity: O(n)
//Space Complexity: O(h) , where h is the height of the tree
// Did the code run successfully on leetcode : yes 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, null, null); // helper(root,min,max)

    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        // base
        if (root == null)
            return true;

        // logic
        if (min != null && root.val <= min)
            return false;
        if (max != null && root.val >= max)
            return false;
        boolean case1 = helper(root.left, min, root.val);
        boolean case2 = helper(root.right, root.val, max);
        return case1 && case2;
    }
}