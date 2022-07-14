# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#          self.right = right
class Solution:
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.prev = None 
        self.isvalid = True

        
        self.inorder(root)
        
        return self.isvalid
        
    def inorder(self,root):
        if (root == None):
            return 
        self.inorder(root.left)
        if(self.prev != None  and self.prev.val >= root.val):
            self.isvalid = False
        
        self.prev = root
        self.inorder(root.right)
        
        
        