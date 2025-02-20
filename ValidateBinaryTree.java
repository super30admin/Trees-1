
/*Time Complexity: O(n) as we processing each node once.
Space Complexity: O(1) no extra space
Leetcode: yes
Any Issues: NO
*/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
           this.left = left;
            this.right = right;
      }
}
class Solution {
    private boolean validate(TreeNode node , long min, long max)
    {
        if(node == null)
            return true;
        if(node.val >= max || node.val <= min)
            return false;
      
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}