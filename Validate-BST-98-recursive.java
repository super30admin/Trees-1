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

 // Recursive Approach
 // Time Complexity: O(n) where n is the number of elements in the in the tree
 // Space Complexity: O(1)
 // As we are doing inorder traversal which means the tree is going to be in ascending order always
class Solution {
    // Keeping isValid and prev as global because they are being used in recursive function
    boolean isValid;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        // checking for ascending order
        if(prev!=null && prev.val>=root.val)
        {
            isValid = false;
            return;
        }
        // storing prev val
        prev = root;
        inorder(root.right);
    }
}
