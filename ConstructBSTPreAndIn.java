/*
https://leetcode.com/problems/validate-binary-search-tree/
98. Validate Binary Search Tree - MEDIUM

TC: O(n) - n = number of nodes/length of the array
SC: O(h) + O(n)
Approach: the first element in the preorder traversal is the root of the tree or subtree.
All elements to the left of this element in the inorder traversal, forms the left subtree
and all elements to the right form the right subtree.
Recurse on the left and right subtrees and assign as root's left and right child.
*/

import java.util.Arrays;

class ConstructBSTPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            return null;
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1);
        int[] preRight = Arrays.copyOfRange(preorder, index+1, preorder.length);
        
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        
        return root;
    }
}