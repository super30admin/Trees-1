/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(N)
// Space Complexity : O(logN)  : recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Preorder traversal : Root, Left, Right
// Inorder Traversal : Left, Root, Right
// We can identify the root element from preorder array. Search the position of the obtained root element
// in inorder array. Elements on left side of the obtained root element will form the left subtree.
// Elements on the right of obtained root node will form the right subtree. This operation will be performed
// recursively until all the elements are visited.

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, inorder.length-1, 0);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart) {
        // Base case
        if(inStart > inEnd || preStart > preorder.length-1) {
            return null;
        }
        // Logic
        // Starting position of root will be the first element in preorder array
        TreeNode root = new TreeNode(preorder[preStart]);
        // find the position of root in inorder array
        // elements on left of this position will form the left subtree
        // elements on the right of this position will form the right subtree
        int i = inStart;
        for(; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                break;
            }
        }
        // forming left subtree recursively
        root.left = helper(preorder, inorder, inStart, i-1, preStart+1);
        // forming right subtree recursively
        root.right = helper(preorder, inorder, i+1, inEnd, preStart + (i-inStart+1));
        return root;
    }
}