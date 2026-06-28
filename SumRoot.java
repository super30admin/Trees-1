import java.util.*;

public class SumRoot {
    int sum;
    public int sumRoot(TreeNode root) {
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
