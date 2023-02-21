// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

  //Definition for a binary tree node.
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

//Solve using recursion, for BST left has to be always less than root
//and root has to be less than right
class Solution {
    boolean isValid=true;
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isValid;         
    }
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        if(prev != null && prev.val>= root.val){
            isValid=false;
            return;
        }
        prev=root;
        inOrder(root.right);
    }
}