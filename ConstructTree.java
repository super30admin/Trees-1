package com.ds.rani.tree;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 * Can you do it both iteratively and recursively?
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7] Return the following binary tree:
 * <p>
 * 3
 * <p>
 * / \
 * <p>
 * 9 20
 * <p>
 * /  \
 * 15 7
 */

//Approach: Taking help of Preorder traversal to find the root element,find the root value in in order traversal
// and based on that create left node and right node

//Time Complexity:o(n^2) where n is number of nodes
//Space Complexity:o(1)

public class ConstructTree {

    /**
     * TreeNode class
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Build tree from Preorder and inorder traversal
     *
     * @param preorder preorder traversal array
     * @param inorder  inorder traversal array
     * @return Build a tree and return its root node
     */
    public static TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {

        return helper( inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1 );
    }

    /**
     * Helper method to create a tree from preorder and inorder traversal
     *
     * @param preOrder preorder traversal array
     * @param inOrder  inorder traversal array
     * @param inStart  start index in inorder array
     * @param inEnd    end index in inorder array
     * @param preStart start index in preOrder array
     * @param preEnd   end index in preOrder array
     * @return root of tree
     */

    static TreeNode helper(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preStart, int preEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        //In PreOrder traversal first node is root node
        int rootVal = preOrder[preStart];
        int inRootIndx = 0;
        //search root value in inOrder traversal
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                inRootIndx = i;
                break;
            }
        }

        TreeNode root = new TreeNode( rootVal );
        root.left = helper( inOrder, preOrder, inStart, inRootIndx - 1, preStart + 1, preEnd );
        //prestart= preStart+ inRootIndx- inStart+ 1,
        // so basically inIndex - instart is size of the roots left subtree,
        // therefore to get the start of right subtree you gotta get to the start of the first value of right subtree within preorder.
        // relative start of the root + left + right tree (preStart) + left sub tree size (inIndex - inStart) + 1 (the root).
        root.right = helper( inOrder, preOrder, inRootIndx + 1, inEnd, preStart  + inRootIndx- inStart + 1, preEnd );

        return root;

    }

}
