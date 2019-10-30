# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time complexity - O(n^2)
#Space complexity -O(n) for the array

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        rootidx = -1
        for index, val in enumerate(inorder):
            if val == root.val:
                rootidx = index
        inleft = inorder[:rootidx]
        preleft = preorder[1:rootidx + 1]
        inright = inorder[rootidx + 1:]
        preright = preorder[rootidx + 1:]
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root
