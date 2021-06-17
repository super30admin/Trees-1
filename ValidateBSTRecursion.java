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
    TreeNode prev;
    boolean result;
    public boolean isValidBST(TreeNode root) {
      //recursive solution
      result = true;
      inOrder(root);
      return result;
    }
  
  private void inOrder(TreeNode root) {
    //base case
    if(root == null) return;
    
//       while(root != null || !st.isEmpty()) {
//         while(root != null) {
//           st.push(root);
//           root = root.left;
//         }
    
        // the above function is equal to below line in the recursion
        inOrder(root.left);
        
        
        // root = st.pop();
        System.out.println(root.val);
        while(prev != null && prev.val >= root.val){
          result = false;
          return;
        }
        prev = root;
        inOrder(root.right);
        System.out.println(root.val);

        //root = root.right;
   }
}