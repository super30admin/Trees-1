// Time Complexity : O(n) where n is number of nodes in tree
// Space Complexity : O(h) where h is the height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use in-order recursive traversal here. We use a global boolean isValid. When travesing in-order if we see that
   val < prev.val, that means it is not a BST and we return false. Else we return true.
*/

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
    TreeNode prev;
    boolean isValid;

    public boolean isValidBST(TreeNode root) {
         isValid = true;

         inorder(root);

         return isValid;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;
        
        inorder(root.left);

        if(prev != null && prev.val >= root.val)
            isValid = false;
        
        prev = root;
        if(isValid)
            inorder(root.right);
    }
}