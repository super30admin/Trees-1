# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : Yes, the program is not optimal.



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0 or len(inorder) == 0:
            return
        else:
            root = preorder[0]
            root_index = 0

            while inorder[root_index] != root:
                root_index += 1

            val = preorder[0]
            left = self.buildTree(preorder[1:root_index + 1], inorder[:root_index])
            right = self.buildTree(preorder[root_index + 1:], inorder[root_index + 1:])

            tnode = TreeNode(val)
            tnode.left = left
            tnode.right = right
            return tnode