public class SumRootRec {
    int sum;

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        helper(root, 0);
        return sum;        
    }
    private void helper(TreeNode root, int currSum) {
        if (root==null) return;

        currSum = currSum * 10 + root.val;
        if (root.right == null && root.left==null) {
            sum += currSum;
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}
