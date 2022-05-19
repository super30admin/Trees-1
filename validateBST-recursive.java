class Solution {
    // Recursive Solution
    // Time complexity is O(h) i.e height of the tree
    // Space complexity is O(n)
    // This solution is submitted on leetcode with no errors
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
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        inorder(root);
        return isValid;
    }
    // Recursive Function
    private void inorder(TreeNode root){
        //base case
        if (root == null) return;
        
        //left node
        inorder(root.left);
        if(prev!= null && prev.val>=root.val)
            isValid = false;
        prev = root;
        
        // right node
        if(isValid) inorder(root.right);
    }
}