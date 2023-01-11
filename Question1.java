// Time Complexity : O(n)
// Space Complexity : O(h) where h is height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Question1 {

public boolean isValidBST(TreeNode root) {

      if (root == null) return true;

      Stack <TreeNode> stack = new Stack<>();

      TreeNode prev = null;

      while(root != null || !stack.isEmpty()){

          while(root != null){

              stack.push(root);

              root = root.left;

          }

          root = stack.pop();

          if(prev != null && root.val <= prev.val) return false;

          prev = root;

          root = root.right;

      }

       return true;

   }

}