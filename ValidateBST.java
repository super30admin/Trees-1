/*
https://leetcode.com/problems/validate-binary-search-tree/
98. Validate Binary Search Tree - MEDIUM

TC: O(n) - every node is visited once
SC: O(h) - max height of the tree, at  any point the max size of the recursive stack will be the height
Approach: use the basic main property of BST. The root node can have value in the range of [-INF, +INF]
Any left child will have the min value as its parent's min value, and max as its parent node's value
Any right child will have the min value as its parent node's value, and max as its parent's max value
A node is a valid BST node if both its left and right child are valid BSTs.
*/

public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }    
    
    // if we start the call as isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)
    // then this will fail for trees having either the MAX or MIN as node value
    public static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        if (min != null && min >= root.val || max != null && max <= root.val) {
            return false;
        }
        
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String args[]) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        root2.right = node;

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        TreeNode node1 = new TreeNode(15);
        node1.left = new TreeNode(6);
        node1.right = new TreeNode(20);
        root3.right = node1;

        System.out.println(isValidBST(root1));
        System.out.println(isValidBST(root2));
        System.out.println(isValidBST(root3));
    }
}