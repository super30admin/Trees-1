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
 // Inorder Trvaersal
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null)
        {
            return true;
        }
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
        {
            return true;
        }
        boolean case1 = validateBST(root.left, min, root.val);
        if((min!=null && min>=root.val) ||  (max!=null && max<=root.val))
        {
            return false;
        }    
        boolean case2 = validateBST(root.right, root.val, max);
        return case1 && case2;
    }
}
