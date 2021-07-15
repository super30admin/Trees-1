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

1 3

Input: [2,1,3]
Output: true
Example 2:

5

/ \

1 4

     / \

    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

## Problem 2

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

9 20

    /  \

15 7

<!-- Time- complexity = O(depth)
space complexity = O(N) -->

class Solution {
boolean result;
TreeNode prev;
public boolean isValidBST(TreeNode root) {
result = true;
inorder(root);
return result;
}

    private void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(prev != null && prev.val >= root.val) {
            result = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }

}

<!-- Time- complexity = O(depth)
space complexity = O(N) -->

class Solution {
HashMap<Integer, Integer> inorderMap;
int preIdx;
public TreeNode buildTree(int[] preorder, int[] inorder) {
if(preorder == null || inorder == null) {
return null;
}

        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length;i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0 , inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inorderMap.get(rootVal);

        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        return root;
    }

}
