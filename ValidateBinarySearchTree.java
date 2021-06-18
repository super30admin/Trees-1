// Time Complexity: O(N) where N is the number of nodes in the tree
// Space Complexity: O(H=N) where H is the height of the tree which in the worst case can be equal to the number of nodes in the tree
// Run on Leetcode: Yes
// Issues: I was trying to merge the two if conditions of min and max into one.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null, null);
    }
    
    private boolean helper(TreeNode root, TreeNode prev, Integer min, Integer max ){
        if(root==null)
            return true;
        
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        
        boolean case1 = helper(root.left, root, min, root.val);
        
        boolean case2 = helper(root.right, root, root.val, max);
        
        return case1&&case2;
    }
    
}
