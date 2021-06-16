// Time complexity - O(N)
// Space complexity - O(N)


class Solution {
    public boolean isValidBST(TreeNode root) {

        return validateBST(root, null ,null);

    }

    private boolean validateBST(TreeNode root, Integer low, Integer high) {

        // checking the base condition
        if(root == null) return true;

        // checking the base condition of the low and high pointers
        if((low!=null && root.val <= low) || (high != null && root.val >= high) ){
            return false;
        }

        // traversing through left and right subtree to validate BST
        return validateBST(root.left, low, root.val) && validateBST(root.right,root.val,high);

    }


}