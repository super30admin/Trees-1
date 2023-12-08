// Time Complexity : O(h) //h is height of the tree
// Space Complexity : O(h) // h being stack space used in recursive call
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -


// Used recursive approach to validate the values of root with its left and right sub trees

/**
 * Definition for a binary tree node.
 */
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
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;

        //logic
        if((min!=null && root.val <= min) || (max!=null && root.val >= max)) return false;

        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right,root.val, max);

        return left && right;
    }

    public static void main(String[] args) {
        ValidateBST v = new ValidateBST();
        boolean res = v.isValidBST(new TreeNode(2147483647, new TreeNode(2147483647),null));
        System.out.println(res);
    }
}
