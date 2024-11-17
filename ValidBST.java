/*
    Time Complexity: O(n), we are visiting all the nodes

    Space Complexity: O(h), h = height of tree, if it is left skewed tree or right skewed tree then stack space
    is O(n), if it is a complete tree O(log n)

    Did the solution run on Leetcode: Yes
 */

/*
  Definition for a binary tree node.
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

class ValidBST {

    TreeNode prev;
    //boolean flag;

    public boolean isValidBST(TreeNode root) {

        //this.flag = true;
        return helper(root);
        //return flag;
    }

    private boolean helper(TreeNode root)
    {
        //base case
        if(root == null)
            return true;

        //if(flag)
        boolean left = helper(root.left);

            if(left == false) return false; // so if there is a breach, it should not traverse other nodes

            if(prev != null && prev.val >= root.val) {
                //flag = false;
                return false;
            }

            prev = root;

        //if(flag)
        boolean right = helper(root.right);

        return left && right;
    }

}