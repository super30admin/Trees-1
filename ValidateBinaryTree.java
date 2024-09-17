/**
// Time Complexity : O(n)
// Space Complexity :O(n) (stack memory)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
  //walk the tree inorder, compare each value to prev global val.
  //since in inorder trversal, paev elem should be smaller.
 */
class Solution {
    double prev = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        if(!isValidBST(root.left))
            return false;

        if(root.val <= prev)
            return false;

        prev = root.val;

        if(!isValidBST(root.right))
            return false;

        return true;
    }
}
