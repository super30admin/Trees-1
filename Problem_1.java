// Time Complexity : O(n), n = number of nodes in tree
// Space Complexity : O(h), h = height of the tree, which is n in worst case. 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    public boolean helper(TreeNode root, Integer low, Integer high){
        if(root == null)
            return true;
        if((low != null && root.val <= low) || (high != null && root.val >= high)){
            return false;
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
