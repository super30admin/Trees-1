class Solution {
    // Solution using int as return type
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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int currSum) {
        // base case
        if(root == null) return 0;
        // preorder
        if(root.left== null && root.right == null) {
            return currSum*10 + root.val;
        }
        int left = helper(root.left, currSum*10+root.val);
        int right = helper(root.right, currSum*10+root.val);
        return left + right;
    }
}