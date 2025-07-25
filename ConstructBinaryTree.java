// Time Complexity : O(n^2) where n is number of nodes in tree
// Space Complexity : O(n^2) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem 2
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.
// Can you do it both iteratively and recursively?
// For example, given
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]

// Return the following binary tree:
//     3
//    / \
//   9  20
//     /  \
//    15   7

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

class Solution{
    public TreeNode buildTree(int[] preorder, int[] inorder){
        // Base case: If the array is empty, return null
        if (preorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }

        // First element in preorder is always the root
        TreeNode root = new TreeNode(preorder[0]);

        // Finding the index of the root in inorder array
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == root.val){
                rootIdx = i;
                break;
            }
        }

        // Creating subarrays for left and right children
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);

        // Recursively building left and right subtrees
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);

        return root;

    }
}