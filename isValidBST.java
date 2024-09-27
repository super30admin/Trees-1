//Time Complexity: O(N)
//Space Complexity: O(N)

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
    TreeNode previous;
    Boolean result;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        result= true;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        if(previous !=null && root.val<=previous.val){
            result = false;
        }
        previous = root;
        inorder(root.right);
    }
}