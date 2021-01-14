// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long lower, long upper){
        if(node==null)
            return true;
        if(node.val<=lower || upper<=node.val)
            return false;
        return helper(node.left,lower,node.val) && helper(node.right,node.val,upper);
    }
}