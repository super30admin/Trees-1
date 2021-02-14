################## Iterative solution
# Time complexity: O(n^2)
# Space complexity: O(depth*2n) for every root node, we create 2 arrays.
# Worked on leetcode: yes
# The first element in the preorder traversal will be the root. We find the root in the inorder traversal, and with that
# index, we split both inorder and preorder traversal into 2 halves.


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder, inorder):

        if len(preorder) == 0: return None

        # In preorder, first element will be the root
        root = TreeNode(preorder[0])

        # search root in the inorder list
        for i in range(len(inorder)):
            if (inorder[i] == root.val):
                index = i
                break

        # creating new arrays
        preorder_left = preorder[1: index + 1]
        preorder_right = preorder[index + 1:]

        inorder_left = inorder[0:index]
        inorder_right = inorder[index + 1:]

        root.left = self.buildTree(preorder_left, inorder_left)
        root.right = self.buildTree(preorder_right, inorder_right)

        return root

