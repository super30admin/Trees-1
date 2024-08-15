// Problem 98. Validate Binary Search Tree
// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class IsValidBST {
    boolean flag; // default = false
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }
    private void helper(TreeNode root, Integer low, Integer high){
        //base
        if(root == null) {
            return;
        }
        // logic
        if((low != null && root.val <= low) || (high != null && root.val >= high)){
            flag = false;
        }
        helper(root.left, low, root.val);
        helper(root.right, root.val, high);
    }
}
