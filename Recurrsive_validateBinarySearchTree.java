//recurrsive method

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer min, Integer max){
        if(root == null) return true;
        if(min!=null && root.val <= min) return false;
        if(max != null && root.val >= max) return false;
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

//recurrsive method

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        helper(root, null, null);
        return flag;
    }
    
    private void helper(TreeNode root, Integer min, Integer max){
        if(root == null) return;
        if(min!=null && root.val <= min) flag =  false;
        if(max != null && root.val >= max) flag = false;
        
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}
