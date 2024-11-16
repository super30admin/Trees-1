/*
 * TC - O(N)
 * SC - O(H) 
 * Approach - Using the range for the min and max value that each node can be 
 * based on the previous nodes 
 */

public class validBst{
    boolean flag;
    public boolean isValidBST(TreeNode root){
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    public void helper(TreeNode root, Integer min, Integer max){
        if(root == null || !flag) return;

        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            flag = false;
        }
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);

    }

    // TreeNode prev = null;
    // public boolean isValidBST(TreeNode root) {
    //     return helper(root);
    // }

    // boolean helper(TreeNode root){
    //     if(root == null) return true;
    //     boolean left = helper(root.left);
    //     if(left == false) return false;
    //     if(prev != null && prev.val >= root.val){
    //         return false;
    //     }
    //     prev = root;
    //     boolean right = helper(root.right);
    //     return left && right;

    // }
}