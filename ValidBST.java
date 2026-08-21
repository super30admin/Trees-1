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

//Time Complexity : O(n)
//Space Complexity: O(h) for skewed where 'h' is the height of the tree
//Space Complexity: O(log n) for non-skewed
class ValidBST {

    // Initialize global variables
    boolean isValidBST = true;
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return isValidBST;
    }

    private void helper(TreeNode root)
    {
        //Base case
        if(root == null) return;

        helper(root.left);

        // Check if current root value is less than or equal to previous root value
        if (prev != null && prev.val >= root.val){
            isValidBST = false;
        }
        prev = root;

        helper(root.right);
    }
}