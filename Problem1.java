//Time complexity : O(n)
// space complexity : O(H)  H = height of tree
// did it run on leetcode = yes

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
    //can be done by using inorder traversal
    boolean result;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        result = true;
        inorder(root);
        return result;
    }
     
    public void inorder(TreeNode root){
        if(root == null)return;
        //checking whether the prev is greater or not
        inorder(root.left);
        if(prev!=null && prev.val >= root.val){
            result= false;
        }
        prev = root;
        inorder(root.right);
    }
}