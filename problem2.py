"""
Time Complexity  : O(n) where n is the number of elements in the tree. 
Space Complexity : O(n) where n is the number of elemenets in the tree. 
Did this code successfully run on Leetcode : Yes

Three line explanation of solution in plain english:
preorder traversal's first node is always the root node.
1. Find the root using Preorder traversal
2. Calculate the inOrderLeft, preOrderLeft, inOrderRight, preOrderRight arrays using pointers instead of creating them
3. Use hashmap to retrieve index of inorder elements in O(1) time
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.hashmap = {}
        self.idx = 0
        
    def helper(self, preorder, start, end):
        #base
        if start > end:
            return None
        
        #Logic
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        rootIdx = self.hashmap[rootVal]
        
        root.left = self.helper(preorder, start, rootIdx - 1)
        root.right = self.helper(preorder, rootIdx+1, end)
        
        return root
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if len(preorder) == 0:
            return None
        
        for idx in range(len(inorder)):
            self.hashmap[inorder[idx]] = idx
        
        return self.helper(preorder, 0, len(inorder)-1)
        
        
        
        