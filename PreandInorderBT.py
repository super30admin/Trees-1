"""
Given two integer arrays preorder and inorder where preorder is the 
preorder traversal of a binary tree and inorder is the inorder traversal 
of the same tree, construct and return the binary tree.

"""

# Time Complexity : O(n) n = number of tree nodes
# Space Complexity : O(n) n = number of inorder nodes
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        mapping = {}
        if preorder is None or len(preorder) == 0:
            return None
        
        for i in range(len(inorder)):
            mapping[inorder[i]] = i
            
        return self.helper(preorder, inorder, 0, len(inorder)-1, mapping)
    
    def helper(self, preorder, inorder, start, end, mapping): 
        if start > end:
            return None
        
        rootVal = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootVal)
        rootIdx = mapping[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx-1, mapping)
        root.right = self.helper(preorder, inorder, rootIdx+1, end, mapping)
        return root