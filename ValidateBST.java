//Time complexity: O(N)
//Space complexity: constant
public class ValidateBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode root){
        if(root == null){
            return true;
        }

        boolean isLeft = helper(root.left);
        if(prev != null && prev.val >= root.val) return false;
        prev = root;

        boolean isRight = helper(root.right);

        return (isLeft && isRight);



    }
}
