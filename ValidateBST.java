//Approach - recursive with local variables min and max
//time - O(n), space - O(h)
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;

        if((min!=null && root.val <= min) || (max!=null && root.val >= max)){
            return false;
        }

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left && right;
    }
}
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
