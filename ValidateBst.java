//Time Complexity: O(N) (as we touch every node once)
//Space Complexity: O(N) (in case of skewed tree)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev;
    boolean isValid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        isValid = true;
        inOrder(root);
        return isValid;
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;
        // to keep search for left subTree
        if(isValid) inOrder(root.left);
        // if prev val stored in global scope greater than root, then set isValid to false
        if(prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        // at every extreme left node, we set the prev to root
        prev = root;
        if(isValid) inOrder(root.right);
    }
}