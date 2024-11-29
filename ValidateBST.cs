//Time: O(n)
//Space: O(1)
//https://leetcode.com/submissions/detail/578259577/
//
using System;
using System.Collections.Generic;

namespace ValidBST
{
    
  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
   public class Solution {

    //Recursive
      public bool IsValidBST(TreeNode root) {
       bool result = helper(root);
        return result;
    }
    TreeNode prev = null;
    private bool helper(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        bool leftResult = helper(root.left);
        if(leftResult == false) {
            return false;
        }
        if(prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        bool rightresult = helper(root.right);
        if(rightresult == false)
            return false;
        return true;
    }

    //using Stacks
    // public bool IsValidBST(TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     TreeNode prev = null;
        
    //     while(root != null || stack.Count > 0) {
    //         while(root != null) {
    //             stack.Push(root);
    //             root = root.left;
    //         }
           
    //         root = stack.Pop();
    //         if(prev!= null && prev.val >= root.val) {
    //             return false;
    //         }
    //         prev = root;
    //         root = root.right;
    //     }
    //     return true;
    // }
}
}
