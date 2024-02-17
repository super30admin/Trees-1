//TC - O(n)
//SC - O(1)

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
class Solution {
    TreeNode prev;
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max) {
        if(root==null) return;
        System.out.println(root.val);
        helper(root.left, min, root.val);
        if((max!=null && root.val>=max) || (min!=null && root.val<=min))
            flag = false;
       if(flag)
        helper(root.right, root.val, max);
    }
}
