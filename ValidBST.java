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
 //Time complexity - O(n)
 //Space compplexity - O(1)
 // did you face any issues- no
 // Solved on leetcode - yes
 // we are maintaining a prev pointer to have the previously visited node and this mut always be less than the current
public class Solution {
    private TreeNode prev = null; // Global variable

    public boolean isValidBST(TreeNode root) {
        return checkBSTHelper(root);
    }

    private boolean checkBSTHelper(TreeNode root) {
        if (root == null) return true;

        if (!checkBSTHelper(root.left)) return false;

        if (prev != null && root.val <= prev.val) return false;
        prev = root;

        return checkBSTHelper(root.right);
    }
}
