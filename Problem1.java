// Time Complexity :
//      h - height of the BST, n is the number of elements
//      isValidBST() - O(2^h + 1) or O(n)
//      
// Space Complexity :
//      isValidBST() - O(h) stored as recursive stack space
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer minim, Integer maxim)
    {
        if(root == null) return true;
        if(maxim != null && root.val >= maxim) return false;
        if(minim != null && root.val <= minim) return false; 
            
        return helper(root.left, minim, root.val) && helper(root.right, root.val, maxim);
    }
}