//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode :Yes
//Approach: Range based check to see if the given node's val is within the range defined for that node, if yes the subtree is valid
//if at any point there is a breach, return false
public class ValidateBSTRangeBased {

    public boolean isValidBST(TreeNode root) {
        //using long instead of int to avoid running into int overflow issues
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max) {
        //base case
        if (root == null) return true;

        //logic
        if (root.val <= min || root.val >= max) return false;
        //recursion: don't recurse the right subtree if the left is not a balance BST

        //if you move to the left subtree, the min remains the same, max will be current root's val
        //since if you're at the root node, the min is -inf and max is +inf
        //if you move to the left subtree, and for it to be balanced,
        // you would need the range to be -inf to root.val, min remains the same, max = root.val
        if (!helper(root.left, min, root.val)) return false;

        //if you move to the right subtree, the max remains the same, min will be current root's val
        //since if you're at the root node, the min is -inf and max is +inf
        //if you move to the right subtree, and for it to be balanced,
        // you would need the range to be root.val to +inf, max remains the same, min = root.val
        return helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        final ValidateBSTRangeBased validateBSTRangeBased = new ValidateBSTRangeBased();

        TreeNode leftInvalid = new TreeNode(6);
        leftInvalid.left = new TreeNode(4);
        leftInvalid.left.left = new TreeNode(7);
        leftInvalid.left.right = new TreeNode(5);
        leftInvalid.right = new TreeNode(11);
        leftInvalid.right.right = new TreeNode(9);

        TreeNode rightInvalid = new TreeNode(15);
        rightInvalid.left = new TreeNode(13);
        rightInvalid.left.left = new TreeNode(12);
        rightInvalid.right = new TreeNode(18);
        rightInvalid.right.left = new TreeNode(17);
        rightInvalid.right.right = new TreeNode(18);

        TreeNode invalid = new TreeNode(10, leftInvalid, rightInvalid);
        System.out.println(validateBSTRangeBased.isValidBST(invalid)); //return false

        TreeNode leftValid = new TreeNode(6);
        leftValid.left = new TreeNode(4);
        leftValid.left.left = new TreeNode(3);
        leftValid.left.right = new TreeNode(5);
        leftValid.right = new TreeNode(7);
        leftValid.right.right = new TreeNode(9);

        TreeNode rightValid = new TreeNode(15);
        rightValid.left = new TreeNode(13);
        rightValid.left.left = new TreeNode(12);
        rightValid.right = new TreeNode(18);
        rightValid.right.left = new TreeNode(17);
        rightValid.right.right = new TreeNode(20);

        TreeNode valid = new TreeNode(10, leftValid, rightValid);
        System.out.println(validateBSTRangeBased.isValidBST(valid)); //return true
    }
}
