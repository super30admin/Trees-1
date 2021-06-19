"""
Recursive Solution.
Time Complexity : O(n) where n is the number of nodes in the tree. 
Space Complexity : O(h) where h is the height of the tree. 
    
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self. prev = None  
        
    def isValidBST(self, root: TreeNode) -> bool: 
        
        def inorder(root):
            
            if not root: return True
            
            if inorder(root.left) == False: return False 
            
            if self.prev != None and self.prev.val >= root.val:
                return False 
            
            self.prev = root
            return inorder(root.right)
                
        return inorder(root)
        
         
            