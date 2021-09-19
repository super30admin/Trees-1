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

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// for itterative: go with the left side of the tree, till the leaf node, and store it to the stack, and pop it once we hit the null. then see the right side of the node and repeat, just compare the prev and the current node
// for recusion: go call the helper function with left of the root first, and then pop the previous value and compare it with the root, then do the same with right side of the root.
// Your code here along with comments explaining your approach
// recursion
class Solution {
    TreeNode prev = null;
    boolean result;
    public boolean isValidBST(TreeNode root) {
        result = true;
        recursion(root);
        return result;
    }
    public void recursion(TreeNode root){
        if( root == null) return;
        recursion(root.left);
        if( prev != null && prev.val >= root.val ){
            result = false;
            return;
        }
        prev = root;
        recursion(root.right);
    }
}

// iterative approach
//
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         Stack<TreeNode> st = new Stack<>();
//         TreeNode prev = null;
//         while(root !=  null || !st.isEmpty()){
//             while(root != null){
//               st.push(root);
//               root = root.left;
//             }
//             root = st.pop();
//             //System.out.println(root.val);
//             if(prev != null && prev.val >= root.val){
//                 return false;
//             }
//             prev = root;
//             root = root.right;

//         }
//         return true;
//     }
