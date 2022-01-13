# Time Complexity : O(n)
 # space Complexity : O(n)
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
        if root == None:
            return true
        else:
            self.inorder(root)
        return self.isValid
    
    def inorder(self, root):
        if root == None:
            return
        self.inorder(root.left)
        if self.prev!= None and self.prev.val>= root.val:
            self.isValid = False
            return 
        self.prev = root
        self.inorder(root.right)
        
        
    
        