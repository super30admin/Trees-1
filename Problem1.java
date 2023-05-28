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


//  Time: O(n) number of nodes
//  Space: O(h) height of tree
class Solution {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {

        return inorder(root);
        // return flag;
    }

    public boolean inorder(TreeNode node){
        if(node == null) return true;
        if(inorder(node.left) == false) return false;
        
        if(prev!=null && prev.val >= node.val){
            return false;
        }
        prev = node;
        return inorder(node. right);
 
    } 
}