# Time Complexity : O(n^2) ##  (can be optimized by storing inorder {element : index} in a hashmap }
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        def helper(preorder, inorder):

            if(len(preorder) == 0):
                return None

            root = TreeNode(preorder[0])
            rootIndex = inorder.index(preorder[0])

            leftInorder = inorder[: rootIndex]
            rightInorder = inorder[rootIndex + 1:]

            leftPreorder = preorder[1: rootIndex + 1]
            rightPreorder = preorder[rootIndex + 1:]

            root.left = helper(leftPreorder, leftInorder)
            root.right = helper(rightPreorder, rightInorder)

            return root

        if(len(preorder) == 0 or len(inorder) == 0):
            return None

        return helper(preorder, inorder)
