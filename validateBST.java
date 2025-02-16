public class validateBST {
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

    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max){
        //base
        if(root == null) return;

        if(max!= null && root.val >= max){
            flag = false;
        }
        if(min!= null && root.val <= min){
            flag = false;
        }

        //logic
        helper(root.left, min, root.val);

        helper(root.right, root.val, max);
    }
}
