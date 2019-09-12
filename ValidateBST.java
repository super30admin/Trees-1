/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 1. The left subtree of a node contains only nodes with keys less than the node's key. 
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key. 
 * 3. Both the left and right subtrees must also be binary search trees.
 * 
 * Idea is to use recursion. 
 * 
 * We have upper and lower bounds on the range where a
 * particular node would take values from, and also recursively check that its
 * subtrees are also valid or not. While making recursive call on the left
 * subtree, the upper bound becomes the current nodes val, similarly while
 * making the recursive call on the right subtree, the lower bound is updated to
 * node's val.
 * 
 * Space Complexity: O(n), worst case 
 * Time Complexity: O(n)
 * 
 * Leetcode Results: 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree. 
 * Memory Usage: 39.1 MB, less than 81.40% of Java online submissions for Validate Binary Search Tree.
 */
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 
     * @param root       current node
     * @param lowerBound root value should be greater than lower bound
     * @param upperBound root value should be less than upper bound
     * @return true is subtree rooted at current node is valid bst, false otherwise
     */
    private boolean validateBST(TreeNode root, long lowerBound, long upperBound) {
        // base case
        if (root == null) {
            return true;
        }
        // check if this node violates the range constraint
        if (root.val >= upperBound || root.val <= lowerBound) {
            return false;
        }
        // recusively check on the left and right subtrees
        return validateBST(root.left, lowerBound, root.val) && validateBST(root.right, root.val, upperBound);
    }
}