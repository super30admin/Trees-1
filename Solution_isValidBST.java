//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_isValidBST {

    boolean flag = true;
    //TreeNode prev = null;

    // private void inorder(TreeNode root){
    //     if(root == null || flag == false)
    //         return;
    //     inorder(root.left);
    //     if(prev != null && prev.val >= root.val)
    //         flag = false;
    //     prev = root;
    //     inorder(root.right);
    // }

    private void helper(TreeNode root, Integer min, Integer max){
        if(root == null || flag == false)
            return;

        if((max != null && root.val >= max) || (min != null && root.val <= min))
            flag = false;

        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root){
        //inorder(root);
        helper(root, null, null);
        return flag;
    }

}
