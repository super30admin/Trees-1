# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder is None or len(preorder) == 0 or inorder is None or len(inorder) == 0:
            return None

        rootVal = preorder[0]
        root = TreeNode(rootVal)
        rootIdx = -1

        for i in range(len(inorder)):
            if rootVal == inorder[i]:
                rootIdx = i

        inLeft = inorder[: rootIdx]
        inRight = inorder[rootIdx + 1:]
        preLeft = preorder[1: rootIdx + 1]
        preRight = preorder[rootIdx + 1:]

        root.left = self.buildTree(preLeft, inLeft)
        root.right = self.buildTree(preRight, inRight)

        return root

# Recursion
# Time Complexity: O(n^2)
# Space Complexity: O(n). Size of the stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
