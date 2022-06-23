// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

//Problem statement: https://leetcode.com/problems/validate-binary-search-tree/

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
class Problem1 {

    boolean flag;
    TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        validate(root);
        return flag;
    }

    public void validate(TreeNode root)
    {
        if (root == null) {
            return;
        }

        validate(root.left);

        if(prev!=null && prev.val >= root.val){
            flag = false;
        }

        prev = root;
        validate(root.right);

    }

}