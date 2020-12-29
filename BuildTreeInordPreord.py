# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC : O(n)
# SC : O(n)
# Approach : We make hashmap to store index of elements of inorder. Then we recursively build our tree 
# by taking roots from preorder and set start and end pointers accordingly in inorder.
class Solution:
    hashmap = {}
    idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not inorder or len(inorder) == 0:
            return None
        
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
            
        return self.helper(preorder, 0, len(inorder) - 1)
    
    def helper(self, preorder, start, end):
        if start > end:
            return None
        
        rootval = preorder[self.idx]
        root = TreeNode(rootval)
        self.idx += 1
        rootIndex = self.hashmap[rootval]
        
        root.left = self.helper(preorder, start, rootIndex - 1)
        root.right = self.helper(preorder, rootIndex + 1, end)
        
        return root

# TC : O(n^2)
# SC : O(n^2)
# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
#         if not inorder or len(inorder) == 0:
#             return None
#         rootval = preorder[0]
#         root = TreeNode(rootval)
#         idx = -1
#         for i in range(len(inorder)):
#             if inorder[i] == rootval:
#                 idx = i
#                 break
#         preLeft = preorder[1: idx+1]
#         preRight = preorder[idx+1: ]
#         inLeft = inorder[0: idx]
#         inRight = inorder[idx+1: ]
#         root.left = self.buildTree(preLeft, inLeft)
#         root.right = self.buildTree(preRight, inRight)
#         return root
        
