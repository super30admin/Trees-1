class Solution {
    // Solution using recursive range with boolean return type
    // Time complexity is O(n)
    // Space complexity is O(h) i.e height of the tree
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
    public boolean isValidBST(TreeNode root) {
        return helper(root, null,null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root == null) return true; // a null node is valid BST
        // logic
        if(min!=null && root.val<=min) return false;
        if(max!=null && root.val>=max) return false;
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        // Can be further optimized using helper && helper
        // right tree won't be tranversed if left is not valid
        return left&&right;
    }
}