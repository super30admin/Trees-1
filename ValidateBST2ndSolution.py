
from tkinter import N
TC: O(N)
SC: O(H)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    isValid = True
       
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def inorder(root,low,high):
            if root == None:
                 return True
            if root.val<low and root.val>high:
                return false 
            
            return inorder(root.left,low,root.val) and                                          inorder(root.right,root.val,high)
        
            
            
                
        return inorder(root, float(-inf), float(inf))
                

