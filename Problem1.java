// TC: O(N)
// SC: O(N)

class Solution {
    public boolean isValidBST(TreeNode root) {
       return validate(root,null,null);
    }

    private boolean validate(TreeNode root, Integer l, Integer r){
        if(root==null) return true;

        if((l!=null && root.val<=l) || (r!=null && root.val>=r)) return false;

        return validate(root.left, l, root.val) && validate(root.right, root.val, r);
    }
}