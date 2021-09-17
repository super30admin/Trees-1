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

// Time Complexity: As we are treversing all the nodes the time complexity us linear - O(n)
// Space Complexity: We have not used any additional data structure: O(1)
// Did you complete it on leetcode: yes
//  Any Problems faced: No

// Write your approach here
// The idea here is to recursively check left and right subtree of each node to determine
// if the left and right subtrees are valid bst,
// at any point of the value of left node is more than maximum or less than minimum
// we can invalidate the BST otherwise it is a valid BST.
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValid(TreeNode root, long min, long max) {
        if(root==null) return true;
        if(root.val>=max || root.val<=min) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}