# Time Complexity : O(n^2)
# Space complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took lot of time to understand how recurrsion return works.

# Your code here along with comments explaining your approach
# 

from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.prev = None

    def isValidBST(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """
        return self.helper(root)

    def helper(self, root):

        if root is None:
            return True
        
        if not self.helper(root.left):
            return False

        if self.prev is not None and self.prev.val >= root.val:
            return False
        
        self.prev = root
        return self.helper(root.right)