"""
Recursive Solution
Time Complexity : O(n)
Space Complexity : O(h)
    
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
        self.result = True 
          
    def isValidBST(self, root: TreeNode) -> bool: 
        
        def inorder(root):
            
            if root:
                inorder(root.left)
                if self.prev != None and self.prev.val >= root.val:
                    self.result = False 
                    return
                self.prev = root
                inorder(root.right)
                
        inorder(root)
        return self.result 
        
         
            