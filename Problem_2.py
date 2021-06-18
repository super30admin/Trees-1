from typing import List
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Time Complexity: O(n * n) because we are searching root index for each node
# Space Complexity :O(n * n) because we are splitting arrays and creating copies
# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
#         if len(preorder) == 0 or len(inorder) == 0:
#             return None
#         rootVal = preorder[0]
#         root = TreeNode(rootVal)
#         rootIdx = 0
#         for i in range(len(inorder)):
#             if inorder[i] == rootVal:
#                 rootIdx = i
                
#         preLeft = preorder[1:rootIdx + 1 ]
#         preRight = preorder[rootIdx + 1:len(preorder)]
#         inLeft = inorder[0 : rootIdx]
#         inRight = inorder[rootIdx + 1 : len(inorder)]
#         root.left = self.buildTree(preLeft, inLeft)
#         root.right = self.buildTree(preRight, inRight)
        
#         return root


# Time Complexity: O(n)
# Space Complexity: O(n) -> used for map
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        self.map = {}
        self.idx = 0
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder)-1)
    
    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> TreeNode:
        if start > end:
            return None
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        rootIdx = self.map[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)
        return root