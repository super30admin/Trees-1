import java.util.*;

class ValidateBST {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }
    private void helper(TreeNode root, Integer min, Integer max) {
        if (root==null) return;
        
        helper(root.left, min, root.val);
        if (min != null && root.val <= min) {
            flag = false;
        }
        if (max != null && root.val >= max){
            flag = false;
        }
        helper(root.right, root.val, max);

    }
}
