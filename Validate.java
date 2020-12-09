/** Given the root of a binary tree, determine if it is a valid binary search tree (BST).
* TC O(N) SC O(N)
* Code was submitted on leetcode
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        int value = root.val;
        if (min != null && value <= min)
            return false;
        if (max != null && value >= max)
            return false;
        return helper (root.left, min, value) && helper(root.right, value, max );
            
    }
}
