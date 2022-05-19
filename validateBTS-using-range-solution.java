class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // Recursive solution using range min and max
    // Time complexity is O(n)
    // Space complexity is O(h) i.e height of the tree
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        helper(root, null, null);
        return isValid;
    }
    private void helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root == null) return;
        helper(root.left,min, root.val);
        if(min!=null && root.val<=min) {
            isValid = false;
            return;
        }
        if(max!=null && root.val>= max) {
            isValid = false;
            return;
        }
        if(isValid) helper(root.right, root.val, max);
    }
}