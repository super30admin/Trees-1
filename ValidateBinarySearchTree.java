// Time Complexity : o(N)
// Space Complexity : o(H)  where H is height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/* we are doing inorder traversal of tree and checking if the tree is sorted by checking the condition prev value should be less
than current root value/
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
class ValidateBinarySearchTree {
    TreeNode prev;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        // check for breach
        if(prev!=null && prev.val >= root.val){
            flag = false;
        }
        prev = root;
        inorder(root.right);
    }

    /* Here we are checking the min  and max range of the root to validate if it is binary search tree*/

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
        boolean flag = true;
        public boolean isValidBST(TreeNode root) {
            helper(root, null, null);
            return flag;
        }

        public void helper(TreeNode root, Integer min, Integer max) {
            // base
            if(root == null) return;

            //logic
            //left baby
            helper(root.left, min, root.val);
            if(min!=null && root.val <= min) {
                flag = false;
            }
            if(max!=null && root.val >= max) {
                flag = false;
            }
            // right baby
            helper(root.right, root.val, max);

        }
    }
}