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

//Time Complexity = O(N)
//Space Complexity = O(1)
class Solution {
    TreeNode prev;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        //base
        if(root == null) return true;
        //logic
        inOrder(root);

        return flag;
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        // if(flag)
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            flag = false;
        }

        prev = root;
        // if(flag)
        inOrder(root.right);
    }
}