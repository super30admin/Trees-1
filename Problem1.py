# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import math
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        self.prev = float('-inf')

        def _inorder(root):
            if not root:
                return True
            
            if not _inorder(root.left):
                return False
            
            if root.val <= self.prev:
                return False
            
            self.prev = root.val
            return _inorder(root.right)  
                
        return _inorder(root)
            
        