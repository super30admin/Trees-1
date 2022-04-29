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

//TC : O(n)
    //SC : O(h) where h is height of tree
class Solution {
    Integer prevValue;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        isValid = true;
        dfs(root);
        return isValid;
    }

    private void dfs(TreeNode root)
    {
        if(root == null || !isValid) return;

        dfs(root.left);
        if(prevValue!=null && prevValue>=root.val)
            isValid = false;
        prevValue = root.val;
        dfs(root.right);

        return;
    }


}