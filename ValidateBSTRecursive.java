class Solution {
    public boolean isValidBST(TreeNode root) {
        long min=Long.MIN_VALUE;
        long max=Long.MAX_VALUE;
        return ValidBST(root,min,max);
    }
    public boolean ValidBST(TreeNode root, long min, long max)
    {
        if(root==null)
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        return ValidBST(root.left,min,root.val) && ValidBST(root.right,root.val,max);
    }
}

// Time Complexity: O(n) as we are visiting all nodes one by one and checking if its in range or not.
// Space Complexity: O(1) as we are not using any extra data structure. But it can also be considered O(h) where h is height of tree if we consider recursive stack for memory.