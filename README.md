# Trees-1

## Problem 1

https://leetcode.com/problems/validate-binary-search-tree/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

   2

   / \

  1   3

Input: [2,1,3]
Output: true
Example 2:

   5

   / \

  1   4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
## solution
public class Solution {

public boolean isValidBST(TreeNode root) {

  return isValid(root, null, null);

}

public boolean isValid(TreeNode root, Integer min, Integer max) {

  if(root == null) return true;

  if(min != null && root.val <= min) return false;

  if(max != null && root.val >= max) return false;

  return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

}
}

## time complexity- o(n)
## space complexity- o(logn)


## Problem 2
## solution
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Given preorder and inorder traversal of a tree, construct the binary tree.



Note:
You may assume that duplicates do not exist in the tree.

Can you do it both iteratively and recursively?

For example, given

preorder = [3,9,20,15,7]


inorder = [9,3,15,20,7]
Return the following binary tree:

   3


   / \


  9  20


    /  \


   15   7
## solution
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Pick the current root from preorder
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder (O(N) search)
        int inorderIndex = findInorderIndex(inorder, rootVal, inStart, inEnd);

        // Recursively construct left and right subtrees
        root.left = buildTreeHelper(preorder, inorder, inStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, inEnd);

        return root;
    }

    private int findInorderIndex(int[] inorder, int target, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target) return i;
        }
        return -1; // Should never happen as input guarantees correctness
    }
}


## time complexity- o(n)
## space complexity- o(n)