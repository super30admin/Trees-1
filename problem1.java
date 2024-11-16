import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class problem1 {
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
    public boolean isValidBST(TreeNode root) {
    helper(root);
    return true;

 }


private void helper(TreeNode root) {
    boolean flag=true;
     if (root == null) return;
     helper(root.left);
     if (prev!=null && prev.val >= root.val)
     {
         flag=false;
     }
     prev=root;
     helper(root.right);

}

}
