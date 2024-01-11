# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> Optional[TreeNode]:
        map_inorder = dict()

        for index, val in enumerate(inorder):
            map_inorder[val] = index

        return self.helper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1, map_inorder)

    def helper(self, preorder, prestart, preend, inorder, instart, inend, map_inorder):
        if prestart > preend or instart > inend:
            return None

        rootVal = preorder[prestart]
        rootidx = map_inorder[rootVal]
        root = TreeNode(rootVal)
        num_left = rootidx - instart

        root.left = self.helper(preorder, prestart + 1, prestart + num_left, inorder, instart, rootidx - 1, map_inorder)
        root.right = self.helper(preorder, prestart + num_left + 1, preend, inorder, rootidx + 1, inend, map_inorder)

        return root