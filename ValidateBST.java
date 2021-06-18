// Time Complexity : O(n)
// Space Complexity : O(h) h -height of the tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no



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
    public boolean isValidBST(TreeNode root) {
      //iterartive solution
      Stack<TreeNode> st = new Stack<>();
      TreeNode prev = null;
      
      //check root is not null and stack is not empty
      while(root != null || !st.isEmpty()) {
        while(root != null) { // inorder left traversal
          // add the parent
          st.push(root);
          root = root.left;
        }
        
        root = st.pop(); // pop the parent move to right
        System.out.println(root.val);
        while(prev != null && prev.val >= root.val) return false;
        prev = root;
        root = root.right;
      }
      
      return true;
    }
}