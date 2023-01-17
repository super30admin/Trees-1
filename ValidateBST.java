// Time Complexity : O(n) 
// Space Complexity : O(h) h -> height of the stack
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
//We are traversing the tree 
//We are returning false if we the value of the previous node is greater than current node value
//Else we are returning true using void recursion or int recursion

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
// class Solution {
//     boolean flag;
//     TreeNode prev;
//     public boolean isValidBST(TreeNode root) {
//         flag = true;
//         helper(root);
//         return flag;
//     }
//     private void helper(TreeNode root){
//         if(root == null) return;
//         helper(root.left);
//         if(prev != null && prev.val >= root.val){
//             flag = false;
//         }
//         prev = root;
//         //st.pop;
//         helper(root.right);
//     }
// }

// class Solution{
//     TreeNode prev;
//     public boolean isValidBST(TreeNode root){
//         return helper(root);
//     }
    
//     public boolean helper(TreeNode root){
//         if (root == null) return true;
//         if (helper(root.left) == false) return false;
//         if(prev != null && prev.val >= root.val){
//             return false;
//         }
//         prev = root;
//         return(helper(root.right));
//     }
// }

// class Solution{
//     Stack<TreeNode> st = new Stack<>();
//     TreeNode prev = null;
//     public boolean isValidBST(TreeNode root){
//         return helper(root);
//     }
//     public boolean helper(TreeNode root){
//         while(root != null || !st.isEmpty()){
//             while(root != null){
//                 st.push(root);
//                 root = root.left;
//             }
//             root = st.pop();
//             if(prev!= null && prev.val >= root.val) return false;
//             prev = root;
//             root = root.right;
//         } return true;
//     }
// }

class Solution{
    
    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        if (root == null) return true;
        if(min != null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right;
    }
}

