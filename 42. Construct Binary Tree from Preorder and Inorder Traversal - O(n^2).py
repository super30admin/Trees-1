# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder is None or inorder is None or len(preorder) == 0 or len(inorder) == 0:
            return None

        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1
        for i in range(len(inorder)):
            if inorder[i] == rootVal:
                rootIdx = i
        # print(rootIdx,"rootIdx")
        inLeft = inorder[: rootIdx]
        # print(inLeft,"inLeft")
        inRight = inorder[rootIdx + 1:]
        # print(inRight, "inRight")
        preLeft = preorder[1: rootIdx + 1]
        # print(preLeft,"preLeft")
        preRight = preorder[rootIdx + 1:]
        # print(preRight,'preRight')
        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root

# Time complexity : O(n^2)
# Space complexity : O(n^2)
# Did this code successfully run on Leetcode? Yes
# Any problem you faced while coding this? No
