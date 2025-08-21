public class ValidateBstConditional {

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
  boolean flag;

  public boolean isValidBST(TreeNode root) {
    inorder(root);
    return flag;
  }

  void inorder(TreeNode root) {
    // base
    // 1. check if root is null
    // 2. check if breach has happened i.e. check if flag is false - don't go ahead to do recursive calls
    if(root == null || !flag) return ;

    // logic 
    inorder(root.left);

    if(prev != null && prev.val >= root.val){
      flag = false;
    }

    prev =root;

    if(flag){
      inorder(root.right);
    }

  }
}
