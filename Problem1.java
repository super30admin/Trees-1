//98. Validate Binary Search Tree

//Time Complexity :O(n)
//Space Complexity :O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Yes


import java.io.*;
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
    boolean isBST = true;
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return false;
        inOrder(root);
        return isBST;
    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(prev != null && prev.val >= root.val){
            isBST = false;
        }
        prev = root;
        inOrder(root.right);
    }
}
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return false;
//         Stack<TreeNode> s = new Stack<>();
//         TreeNode prev = null;
        
//         while(root != null || !s.isEmpty()){
//             while(root != null){
//                 s.push(root);
//                 root = root.left;
//             }
//             root = s.pop();
//             if(prev != null && prev.val >= root.val){
//                 return false;
//             }
//             System.out.println(root.val);
//             prev = root;
//             root = prev.right;
//         }
//         return true;
//     }
// }