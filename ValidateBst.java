// TC : O(n)
// SC : O(h) - maximum height of tree
// Approach :



public class ValidateBst {

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

  long prev = Long.MIN_VALUE;
  boolean isValid = true;

  public boolean isValidBST(TreeNode root) {
    inorder(root);
    return isValid;
  }

  void inorder(TreeNode root) {
    if (root.left != null) {
      inorder(root.left);
    }

    int val = root.val;

    if (prev >= val) {
      isValid = false;
      return;
    }

    prev = val;

    if (root.right != null) {
      inorder(root.right);
    }
  }

  public static void main(String[] args) {

    ValidateBst validator = new ValidateBst();

    // Create a sample BST: [2, 1, 3]
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    boolean result = validator.isValidBST(root);
    System.out.println("Is valid BST: " + result);
  }
}
