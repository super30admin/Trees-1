

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }
    public void helper(TreeNode root, Integer min, Integer max){
        if(root == null) return;
        if(min != null && root.val<=min){
            flag = false;
        }
        if(max != null && root.val>=max){
            flag = false;
        }
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}