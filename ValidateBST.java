import java.util.Stack;

public class ValidateBST {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
      this.val = data;
      left = right = null;
    }
  }

  public static boolean isValidBST(TreeNode root) {

    if (root == null)
      return true;

    Stack<TreeNode> stack = new Stack<>();
    TreeNode pre = null;
    while (root != null || !stack.isEmpty()) {
      // left
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // do
      if (pre != null && pre.val >= root.val)
        return false;
      // record predecessor
      pre = root;
      // right
      root = root.right;
    }

    return true;

  }

}
