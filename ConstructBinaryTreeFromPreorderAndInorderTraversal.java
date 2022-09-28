// Time Complexity : O(n) where n = number of elements in tree
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//105. Construct Binary Tree from Preorder and Inorder Traversal (Medium) - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
// Time Complexity : O(n*n) where n = length of the array
// Space Complexity : O(n*n) where n = length of the array
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        // find root in inorder array
        int index = -1;
        
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] preorderLeft = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] preorderRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        
        return root;
    }
}