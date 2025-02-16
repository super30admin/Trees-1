// Time Complexity: O(n) where n is the number of nodes in the tree
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: We will be using the recursive approach to solve this problem. We will be passing the root node, min and max values to the helper function.

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
class ValidateBST {
    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max){
        // base
        if(root == null){
            return true;
        }

        // logic
        boolean left = helper(root.left, min, root.val);

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }

        boolean right = false;

        if(left){
            right = helper(root.right, root.val, max);
        }

        return left && right;
    }
}