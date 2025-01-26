# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.checkValid(root,float(-inf),float(inf),)    
    
    def checkValid(self,currentNode,min,max):
        
        
        if currentNode == None:
            return True
        
        
        if min<currentNode.val and currentNode.val<max:
            # True Case
            
            # 1. Check LHS == TRUE, 
            # 2. Then check for RHS and return the result either True or False
            if self.checkValid(currentNode.left,min,currentNode.val) == True:
                return self.checkValid(currentNode.right,currentNode.val,max)
            
        else:
            return False