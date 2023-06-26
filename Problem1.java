// Time Complexity : O(n)
// Space Complexity : O(1)
    // n is the number of nodes present in the tree.

// Your code here along with comments explaining your approach
    //We use a global variable to keep a track of previous visited number.
    //We traverse the tree in an Inorder fasion, left->root->right. If we come across a situation where the prev number is greater or equal to the current number, we return false.
    //We use a recursive function for this. In that, we explore left subtree before checking the condition(current>prev). If the left subtree is valid, then only we check for right subtree. We return the "and" of both answers.

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

    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        if (root==null)
        {
            return true;
        }
        boolean leftCheck = isValidBST(root.left);
        if (prev!=null && root.val<=prev)
        {
            return false;
        }
        prev = root.val;
        return leftCheck && isValidBST(root.right);
    }
}