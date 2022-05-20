# Time Complexity : O(h) where h is height of the tree
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.is_valid = True
        self.prev = None
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.inOrder(root)
        
        return self.is_valid
        
    def inOrder(self, curr):
        #Base Condition
        if curr == None:
            return

        #Logic
        #Exploring left subtree
        self.inOrder(curr.left)
        
        #Printing current node         
        if self.prev != None and self.prev.val >= curr.val:
            self.is_valid = False
        
        self.prev = curr
        
        #Exploring left subtree
        self.inOrder(curr.right)