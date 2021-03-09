class ValidateBinarySearchTree_98 {
    

    public boolean validateBinarySearchTree(TreeNode root) {
        if(root == null) return false;
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode tree, Integer min, Integer max) {
        if(tree==null) return true;
        if((min!=null && tree.val <= min) || (max!=null && tree.val >= max)){
            return false;
        }
        boolean isLeftValie = isValid(tree.left, min, tree.val);
        boolean isRightValie = isValid(tree.left, tree.val, max);
        return isLeftValie && isRightValie;
    }

    // [5,4,6,null,null,3,7]
 
    public static void main(String[] args) {
        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        TreeNode leftOne = new TreeNode(4, null,null);
        TreeNode rightOne = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        TreeNode root = new TreeNode(5, leftOne, rightOne);
        boolean isValid = validateBinarySearchTree_98.validateBinarySearchTree(root);
        System.out.println("The value is"+isValid);
    }
}