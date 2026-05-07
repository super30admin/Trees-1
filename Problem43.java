// Time Complexity: O(N)
// Space Complexity: O(h) - height/depth of the tree

class Solution {
    private boolean flag;
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root) {
        //base
        if(root == null) return;

        //logic
        helper(root.left);
        if (this.prev != null && this.prev.val >= root.val) {
            this.flag = false;
        }
        prev = root;
        helper(root.right);
    }
}