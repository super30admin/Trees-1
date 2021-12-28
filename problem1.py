# Time Complexity : O(n)
# Space Complexity : O(N)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 
# Your code here along with comments explaining your approachclass Solution:

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
class Solution:
    def helper(self,root,minv,maxv):
        if root == None:
            return True
        if (root.val <maxv) and ( root.val >minv):      
            return  self.helper(root.left,minv,root.val) and self.helper(root.right, root.val,maxv)
        else:
            return False

    
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        return self.helper(root, -sys.maxsize,sys.maxsize)
