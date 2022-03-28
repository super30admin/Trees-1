// Time Complexity : O(n)
// Space Complexity : O(h) - height of tree
// Did this code successfully run on Leetcode : Yes

public class ValidateBST {

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

    TreeNode prev;
    // boolean flag;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        // flag = false;
        return inorder(root);
        // return flag;
    }

    private boolean inorder(TreeNode root){
        if(root == null) return true;
        boolean left = inorder(root.left);
        System.out.println("Up");
        System.out.println(root.val);
        if(prev!= null && prev.val >= root.val){
            return false;
        }
        prev = root;
        boolean right = inorder(root.right);
        return left && right;
    }

}
