class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null , null);

    }

    private boolean helper(TreeNode root, Integer min, Integer max){

        if(root == null)
        {
            return true;

        }
        if(max != null && root.val >= max) return false;
        if(min != null && root.val  <= min) return false;

        boolean left =  helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);

        return left&&right;
    }
}
