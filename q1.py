from typing import Optional
# Time Complexity : O(n), Where n is number of nodes in the Binary Search Tree
# Space Complexity : O(h), Where h is the height of Binary Search Tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    
    
    def __init__(self):
        #Object variables
        self.isBST=True
        self.prev=None
        
    def inorder(self,root):
        #Base Case
        if(root==None):
            return
        #Actual Logic
        self.inorder(root.left)
        if(self.prev!=None and self.prev.val>=root.val):
            self.isBST=False
            return
        self.prev=root
        self.inorder(root.right)
       
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inorder(root)
        return self.isBST