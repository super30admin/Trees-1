# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        #n=len(root)
        
        """if(n==3):
            if(root[1]<root[0] and root[2]>root[0]):
                return True
            else:
                return False"""
        return self.valid(root,float('-inf'),float('inf'))
    
    def valid(self,root,left,right):
        if root is None:
            return True
        
        if root.val>=right or root.val<=left:
            return False
        
        return self.valid(root.left,left,root.val) and self.valid(root.right,root.val,right)