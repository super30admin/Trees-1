
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {

  TreeNode k =null;
  boolean flag = true;
  public boolean isValidBST(TreeNode root) {

    InOrder (root);
    return flag;

  }

  private void InOrder (TreeNode root){

    if (root == null)return;
    InOrder(root.left);

    if (k != null && (root.val  <= k.val )){
      flag = false;
    }

    k= root;
    InOrder(root.right);

  }
}