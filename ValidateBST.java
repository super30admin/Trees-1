// Time Complexity : O(N) where N is total number of nodes in tree
// Space Complexity : O(N) in worst case
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
// We need to determine whether left child of a node is less than the node and right child of the node is greater than
// the node. The same rule should hold true for the right child of the node and the left child of node. We will traverse
// from root to left and push everything in the stack. Once we reach the left most node we verify whether its left child is less than and right child
// is more than that current node. Once that node is processed, we perform the same for its right child(if it has the right child)
// If at any node the rule does not hold good we return false.


// Your code here along with comments explaining your approach

import java.util.Stack;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (previous != null) {
                if (root.val <= previous.val) return false;
            }
            previous = root;
            root = root.right;
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
