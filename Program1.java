//Time o(n) n is no of nodes
//space o(h) where h is the height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        //base cases
        if(root == null)
            return true;
        //logic
        if((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}