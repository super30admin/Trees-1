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

 // Iterative Approach
 // Time Complexity: O(n) where n is the number of elements in the in the tree
 // Space Complexity: O(1)
 // As we are doing inorder traversal which means the tree is going to be in ascending order always
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
        {
            return true;
        }
        return inorder(root);
    }

    private boolean inorder(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        boolean case1 = inorder(root.left);
        if(prev!=null && prev.val >= root.val)
        {
            return false;
        }
        prev = root;
        boolean case2 = inorder(root.right);
        return case1 && case2;
    }
}
