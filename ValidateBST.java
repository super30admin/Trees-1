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

// Approach: Inorder traversal with limits
// Time: O(N) where N = number of nodes
// Space: O(h) for recursive stack. h = height of the tree.
 class Solution {

    List<Integer> inorderList;

    public boolean isValidBST(TreeNode root) {

        inorderList = new ArrayList<>();
        return inorder(root, null, null);
    }

    private boolean inorder(TreeNode root, Integer lowerLimit, Integer upperLimit) { // use Integer to accept null values
        
        // base
        if (root == null) {
            return true;
        }
        
        // logic
        if ((lowerLimit != null && root.val <= lowerLimit) || (upperLimit != null && root.val >= upperLimit)) {
            return false;
        }
        
        // recurse and return
        return inorder(root.left, lowerLimit, root.val) && inorder(root.right, root.val, upperLimit);
    }
}