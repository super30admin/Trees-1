package validateBST;


import java.util.Stack;

//Time Complexity: O(n), where n is the number of nodes in the tree (since each node is visited once).
//Space Complexity: O(h), where h is the height of the tree. In the worst case (unbalanced tree), this is O(n), and in the best case (balanced tree), it is O(log n).


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
class Iterative {
    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()) {

            while(root != null ) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(prev != null && root.val <= prev.val) return false;

            prev = root;
            root = root.right;
        }

        return true;
    }
}