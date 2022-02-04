#TimeComplexity:O(n)
#SpaceComplexity:O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
# Ran a recursive function to check if BST condition holds



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    prev = TreeNode(None,None,None)
    
    isValid = True
    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        # if root.left == None and root.right == None:
        #     return True
        
        self.inOrder(root)
        
        return self.isValid
        
        
        return False
    
    def inOrder(self,root):
        
        if(root == None):
            return
        
        self.inOrder(root.left)
       
        if self.prev.val is not None :
          
            if self.prev.val >= root.val:
                
                self.isValid = False
        
        self.prev = root
        
        self.inOrder(root.right)
