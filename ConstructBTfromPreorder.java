// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class ConstructBTfromPreorder {   
  /*
  Definition for a binary tree node.
  */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int nextRootId = map.get(preorder[idx]);
        
        TreeNode root = new TreeNode(preorder[idx]);
        idx++;
        root.left = helper(preorder, start, nextRootId - 1);
        root.right = helper(preorder, nextRootId + 1, end);
        return root;
    }
}