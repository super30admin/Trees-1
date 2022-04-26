// love this approach
// that way you would cover multiple appraoches

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
         return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.val <= min) return false; // first condition is to catch the condition where min is null
        if(max != null && root.val >= max) return false;
        
        boolean case1 = helper(root.left, min, root.val);
        boolean case2 = helper(root.right, root.val, max);
        
        return case1 && case2; 
    }
} 