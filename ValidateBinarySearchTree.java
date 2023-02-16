// TC: O(n)
// SC: O(n) (considering the recursive stack space)
class Solution {
    boolean result = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return false;
        }
        valid(root);
        return result;
    }
    private void valid(TreeNode root) {
        if(root == null) {
            return;
        }
        valid(root.left);
        if(prev != null && root.val <= prev.val) {
            result = false;
            return;
        }
        if(result == true) {
            prev = root;
            valid(root.right);
        }
    }
}