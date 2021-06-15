// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidBST(TreeNode root) {
       return checkBST(root, null, null);
    }
    
    public boolean checkBST(TreeNode root, Integer max, Integer min) {
        if(root == null) return true;
        
        else if((max!=null && root.val >=max) || (min!=null && root.val <= min)) return false;
        
        else
            return checkBST(root.left, root.val, min) && checkBST(root.right, max, root.val);
    }
}
