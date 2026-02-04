''' 
Time Complexity : O(2) 
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import copy
class Solution:
    def __init__(self):
        self.flag = True
        self.prev = None
    
    def helper(self, root):
        if root == None:
            return
        
        self.helper(root.left)

        # write condition to make the flag false
        if self.prev != None and self.prev.val >= root.val:
            self.flag = False
        self.prev = root

        self.helper(root.right)

    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        if root == None:
            return True
        
        self.helper(root)

        return self.flag