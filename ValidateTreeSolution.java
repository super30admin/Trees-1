// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Will do an iterative in-order traversal and check if it is ascending order.

public class ValidateTreeSolution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        TreeNode curr = root;
        Stack<TreeNode> s = new Stack<>();
        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if(prev != null && prev.val >= curr.val) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}