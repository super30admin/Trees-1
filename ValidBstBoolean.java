// Non-conditional boolean based recursion

public class ValidBstBoolean {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  TreeNode prev;

  public boolean isValidBST(TreeNode root) {
    return inorder(root);
  }

  private boolean inorder(TreeNode root) {
    // base
    if (root == null)
      return true;

    // logic
    boolean left = inorder(root.left);

    if (prev != null && prev.val >= root.val) {
      return false;
    }

    prev = root;

    boolean right = inorder(root.right);

    return left && right;
  }
}
