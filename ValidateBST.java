package week3;

public class ValidateBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        TreeNode prev;
        boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        //return helper(root);
        return helperApproach2(root,null, null);
    }

    private boolean helper(TreeNode root) {
        if(root == null) return true;
        if(helper(root.left) == false) return false;
        if(prev!=null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return helper(root.right);
    }

    private boolean helperApproach2(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(max != null && root.val >= max) return false;
        if(min != null && root.val <= min) return false;
        return helperApproach2(root.left, min, root.val) && helperApproach2(root.right, root.val, max);
    }

}
