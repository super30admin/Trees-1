/*
Known Issue: Doesn't work appropriately (First attempt)
*/


class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean check(TreeNode root, int minVal, int maxVal){
        
        if(root == null)
            return true;
        
        if(root.val > minVal && root.val < maxVal){
            if(check(root.left, Integer.MIN_VALUE, root.val) && check(root.right, root.val, Integer.MAX_VALUE))
                return true;
        }
        return false;
    }
}