""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.d = {}
        self.Idx = 0

    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        for i in range(len(inorder)):
            self.d[inorder[i]] = i

        return self.helper(preorder, 0, len(preorder) - 1)

    def helper(self, preorder, start, end):
        if start > end:
            return None
        rootVal = preorder[self.Idx]
        self.Idx += 1
        root = TreeNode(rootVal)
        rootIdx = self.d[rootVal]

        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx + 1, end)
        return root

# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         if len(preorder)==0:
#             return None
#         rootVal=preorder[0]
#         rootIdx = -1
#         root = TreeNode(rootVal)
#         for i in range(len(inorder)):
#             if inorder[i] == preorder[0]:
#                 rootIdx = i
#                 break

#         inLeft=inorder[:rootIdx]
#         inRight=inorder[(rootIdx+1):]
#         preLeft=preorder[1:(len(inLeft)+1)]
#         preRight=preorder[(len(inLeft)+1):]

#         root.left=self.buildTree(preLeft, inLeft)
#         root.right=self.buildTree(preRight, inRight)
#         return root

