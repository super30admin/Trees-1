// Time Complexity : O(n) --> where n is length of input array
// Space Complexity : O(h) --> where h is height of tree (log n - n)
// Did this code successfully run on Leetcode (98): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    TreeNode prev;
    
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        return inorder(curr);
    }
    private boolean inorder(TreeNode curr) {
        // base condition
        if (curr == null) return true;
        
        // logic
        if (inorder(curr.left) == false) return false;
        if (prev != null && prev.val >= curr.val) return false;
        prev = curr;
        return inorder(curr.right);
    }
}