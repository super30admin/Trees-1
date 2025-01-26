class ValidateBinarySearchTree {

    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right==null)) {
            return true;
        }
        isValid = true;
        validateBst(root, null, null);
        return isValid;
    }

    public void validateBst(TreeNode root, Integer min, Integer max){
        if(root == null){
            return;
        }

        validateBst(root.left, min, root.val);
        if((max!=null && root.val >= max) || (min!=null && root.val <= min)){
            isValid = false;
            return;
        }
        validateBst(root.right, root.val, max);
    }
}
