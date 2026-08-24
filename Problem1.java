//O(n) space complexity
O(1) time complexity
  ///validate BST

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

    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
    this.flag = true;
    helper(root);
    return flag;
        
    }

    public void helper(TreeNode root) {

        if(root == null){ return;}
        
       
        if(flag) {
        helper(root.left);
        }
        if(prev != null && prev.val >= root.val){

            flag = false;
        }
        prev = root;


        if(flag){
        helper(root.right);
        }
    }
}
