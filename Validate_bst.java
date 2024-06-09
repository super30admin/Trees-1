// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// For iterative method save each left node on the stack. When null node is reach pop from stack
// similar apporoach is for recursive. before recursive call save it on the stack and after recursive call 
// pop it from stack  

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
 // Recurcive approach - Independant of traversal 
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return ValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     public boolean ValidBST(TreeNode node, long min, long max){
//     if(node == null) {
//         return true;
//     }
//     // R L R with if at first
//     if(node.val <= min || node.val >= max){
//         return false;
//     }
//     return( ValidBST(node.left, min, node.val) && ValidBST(node.right,node.val, max));
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode prev = null;
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            
            if(prev != null && prev.val >= root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}