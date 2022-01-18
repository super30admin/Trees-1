# Recursive Approach 
# // Time Complexity : O(H)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    prev = TreeNode()
    flag = bool()
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        
        self.flag = True
        self.prev = None
        self.inorder(root)
        return self.flag
    
    def inorder( self, root: Optional[TreeNode]):
        if root == None:
            return
        
        self.inorder(root.left)
        #stack.pop
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
            
        self.prev = root
        self.inorder(root.right)
         #stack.pop
        
    
        
            
            
        