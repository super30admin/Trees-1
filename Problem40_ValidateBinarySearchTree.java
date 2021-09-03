// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if(node == null)
            return true;
        int val = node.val;
        if(lower != null && val <= lower)
            return false;
        if(upper != null && val >= upper)
            return false;
        if(!helper(node.left, lower, val))
            return false;
        if(!helper(node.right, val, upper))
            return false;
        return true;
    }
}