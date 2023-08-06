import javax.swing.tree.TreeNode;

//Time complexity:  O(n)
//Space complexity: O(h)
public class ValidateBinarySearchTree {

     // Definition for a binary tree node.
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
    class Solution {
        boolean flag;
        TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            this.flag = true;
            dfs(root);
            return flag;
        }

        public void dfs(TreeNode root){
            if(root==null) return;
            dfs(root.left);
            if(prev!=null && prev.val >= root.val) {flag = false;}
            prev = root;
            dfs(root.right);
        }
    }
}
