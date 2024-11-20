// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes

import com.sun.source.tree.Tree;

public class ValidBST {
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
    TreeNode prev;
    boolean flag;

    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        if(flag){
            helper(root.left);

            if(prev != null && prev.val >= root.val){
                flag = false;
            }
            prev = root;
            helper(root.right);
        }
    }


}
