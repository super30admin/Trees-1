"""
Time Complexity : O(n). 
Space Complexity : O(n).
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.index = 0 
        self.hash_ = {}
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder:
            return None 
    
        for i,j in enumerate(inorder):
            self.hash_[j] = i
        
        def helper(preorder, s, e):
            if s > e: return None
            rootval = preorder[self.index]
            self.index += 1 
            
            node = TreeNode(rootval)
            idx = self.hash_[rootval]
            
            node.left = helper(preorder, s, idx - 1)
            node.right = helper(preorder, idx + 1, e)
            return node
            
        return helper(preorder, 0, len(inorder) - 1)
        

            