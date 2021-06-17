// Time complexity - O(N)
// Space complexity - O(N)


class Solution {
    public boolean isValidBST(TreeNode root) {

        return validateBST(root, null ,null);

    }

    private boolean validateBST(TreeNode root, Integer low, Integer high) {

       
        if(root == null) return true; //base condition

        if((low!=null && root.val <= low) || (high != null && root.val >= high) ){
            return false;
        }

       
        return validateBST(root.left, low, root.val) && validateBST(root.right,root.val,high);

    }


} 