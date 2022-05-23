//Time Complexity: O(n)
//Space Complexity:o(n)
//Did this code successfully run on Leetcode :Yes

class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        return isValidSubtree(root, null, null);
    }
    boolean isValidSubtree (TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.val <= min) ||  (max != null && root.val >= max)) return false;
        return isValidSubtree (root.left, min, root.val) && isValidSubtree(root.right, root.val, max);

    }
}