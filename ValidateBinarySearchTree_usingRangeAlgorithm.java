// Time Complexity : O(n) as we need to visit all nodes to check the bst violation
// Space Complexity : O(n) is the space occupied on the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Validate Binary Search Tree
 * */

/*
 * Approach: Range based algorithm - In this approach, we use range based algorithm. We define the ranges from
 * min - max for each subtree and check if any node falls out of that range. If any node's value is out of range,
 * we simply return false. If towards the end, we do not see any such violation, that means the tree is a valid BST.
 * */

public class ValidateBinarySearchTree_usingRangeAlgorithm {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBinarySearchTree_usingRangeAlgorithm validateBinarySearchTree = new ValidateBinarySearchTree_usingRangeAlgorithm();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer min, Integer max) {
        // base case
        if (node == null) return true;

        // logic
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // AND operator should take care of the short-circuiting in that it will ignore the
        // right side recursion if left side violates the bst property

        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
