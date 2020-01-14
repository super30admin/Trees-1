// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root,Long.MIN_VALUE, Long.MAX_VALUE);	// returns if the given tree is BST or not
    }

    public boolean validateBST(TreeNode root, long min, long max){		// helper function to recursively iterate through the tree, min and max are initialized to default 
        if(root == null)	// if root is null, we have either reached the last child or there is only one element
            return true;

        if(root.val <= min || root.val >= max)	// to satisfy the BST condition, the current node should be less the root value
            return false;

        return (validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max));	// recursively iterate through the left and right subtree
    }
}