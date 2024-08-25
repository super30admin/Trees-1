# Time: O(n2)
# Space: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0:
            return None
        root = TreeNode(preorder[0])
        idx = -1
        # find root in inorder
        for i in range(len(inorder)):
            if inorder[i] == root.val:
                idx = i
                break
        inLeft = inorder[:idx]
        inRight = inorder[idx + 1:]
        # print(len(inLeft))
        preLeft = preorder[1: len(inLeft)+1]
        preRight = preorder[len(inLeft) + 1:]
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)
        return root