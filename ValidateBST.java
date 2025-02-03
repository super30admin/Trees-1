// Approach: For the left and right subtrees rooted at a particular node, the maximum and minimum values, respectively, should be the
// root value. The overall minimum and maximum values should initially be negative and positive infinity, respectively, since no node
// value can be smaller than negative infinity or greater than positive infinity. If all nodes in the given tree satisfy this constraint,
// the tree is a BST.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/validate-binary-search-tree/description/

import java.util.List;
import java.util.ArrayList;

public class ValidateBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode (int v) {
            val = v;
        }
    }

    boolean validateBSTUsingInorder(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i) >= inorder.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    void traverse(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        traverse(root.left, inorder);
        inorder.add(root.val);
        traverse(root.right, inorder);
    }

    boolean validateBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validateBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBST vbst = new ValidateBST();
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println("Given Binary tree is a BST (true/false): " + vbst.validateBST(root));
    }
}