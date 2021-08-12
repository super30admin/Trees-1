//https://leetcode.com/problems/validate-binary-search-tree/
/*
Time: O(N)
Space: O(N) for the run-time stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class ValidBST {

    public static boolean isValidBST(TreeNode root)
    {
        return helper(TreeNode root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        return min < node.val && node.val < max && helper(node.left, min, node.val)
                && helper(node.right, node.val, max);
    }

}
