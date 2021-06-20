"""
Time Complexity : O(n^2). 
Space Complexity : O(n^2).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None 
        
        root = TreeNode(preorder[0])
        rootval = preorder[0] 
        index = 0 
        
        for i in range(len(inorder)):
            if inorder[i] == rootval:
                index = i 
        
        inleft = inorder[0:index]
        inright = inorder[index+1:]
        preleft = preorder[1:index+1]
        preright = preorder[index+1:]
        
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        
        return root
            
            