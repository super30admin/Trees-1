/**
 * Time Complexity : O(log N) where N = height of tree
 */

import java.util.*;
public class ValidBST {
    public boolean isValidBST3(TreeNode root) {
        return helper(root, null,null);
    }
    public boolean helper(TreeNode root, Integer min, Integer max)
    {
        if(root == null) return true;
        if((max!=null && root.val >= max) || (min!=null && root.val <= min) )return false;
        return helper(root.left,min,root.val) && helper(root.right,root.val,max);
    }

    TreeNode prev = null;
    public boolean isValidBST2(TreeNode root) {
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root)
    {
        if(root == null) return true;
        if(inOrder(root.left)==false) return false;
        if(prev!=null && prev.val >= root.val) return false;
        prev = root;
        return inOrder(root.right);
    }



    public boolean isValidBST1(TreeNode root) {
        TreeNode prev = null;
        if(root==null) return true;
        Stack<TreeNode> st = new Stack<TreeNode>();

        while(root!=null || !st.isEmpty())
        {
            while(root!=null)
            {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev!=null && prev.val>=root.val)
            {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}

  class TreeNode {
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
