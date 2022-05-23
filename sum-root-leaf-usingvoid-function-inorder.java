class Solution {
    // Solution using void function Inorder
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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int currSum) {
        // base case
        if (root == null) return;
        // logic
        helper(root.left, currSum*10 + root.val);
        // Inorder
        if(root.left == null && root.right == null){
            sum+= currSum*10 + root.val;
            return;
        }
        helper(root.right, currSum*10 + root.val);
    }
}