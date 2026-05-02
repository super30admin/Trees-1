# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder, inorder):
        self.index = 0
        self.inorder_map = {}
        for i in range(len(inorder)):
            ele = inorder[i]
            self.inorder_map[ele] = i
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        if start > end:
            return None
        root = TreeNode(preorder[self.index])
        idx = self.inorder_map[root.val]
        self.index += 1
        root.left = self.helper(preorder, start, idx - 1)
        root.right = self.helper(preorder, idx + 1, end)
        return root
