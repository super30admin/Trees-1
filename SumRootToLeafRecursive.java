// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // initalize sum
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // return 0 if tree is empty
        if(root == null) return 0;
        // call recursive function
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        // base
        // return if root is null
        if(root == null) return;
        //  keep pushing left children in stack
        helper(root.left, num * 10 + root.val);
        // pop recursive stack
        if(root.left == null && root.right == null){
            sum += num * 10 + root.val;
        }
        // keep pushing right children in stack
        helper(root.right, num * 10 + root.val);
    }
}