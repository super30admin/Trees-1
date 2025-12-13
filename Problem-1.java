// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english:
// Perform an inorder traversal of the tree.
// In a valid BST, inorder values must be strictly increasing.
// If any value is not greater than the previous one, return false.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inorder = new ArrayList<>(); 
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    private boolean dfs(TreeNode root){
        if (root == null){
            return true;
        }

        if (!dfs(root.left)){
            return false;
        }
        int size = inorder.size();
        if (!inorder.isEmpty() && inorder.get(size-1)>=root.val){
            return false;
        }
        inorder.add(root.val);
        return dfs(root.right);
    }
}