# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hashIndices = {}
        self.index = -1

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        for i in range(len(inorder)):
            self.hashIndices[inorder[i]] = i

        return self.buildNode(preorder, 0, len(preorder)-1)

    def buildNode(self, preorder, start, end):
        # base case
        if start > end or self.index >= len(preorder):
            return None

        # logic
        self.index += 1
        root = TreeNode(preorder[self.index])
        rootIndex = self.hashIndices[preorder[self.index]]
        root.left = self.buildNode(preorder, start, rootIndex-1)
        root.right = self.buildNode(preorder, rootIndex+1, end)

        return root