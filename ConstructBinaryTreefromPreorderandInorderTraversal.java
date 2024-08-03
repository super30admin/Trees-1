// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    Map<Integer, Integer> hashmap;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      hashmap = new HashMap<>();
      index=0;
      // Populating hashmap with inorder
      for(int i = 0; i<inorder.length; i++) {
        hashmap.put(inorder[i], i);
      }
      return helper(preorder, 0, preorder.length-1);
    }
  
    TreeNode helper(int[] preorder, int start, int end) {
      // Base
      if(start>end) return null;
      // Logic
      int rootValue = preorder[index];
      index++;
      TreeNode root = new TreeNode(rootValue);
      int rootIndex = hashmap.get(rootValue);
      // Recurse
      root.left = helper(preorder, start, rootIndex-1);
      root.right = helper(preorder, rootIndex+1, end);
      return root;
    }
  }