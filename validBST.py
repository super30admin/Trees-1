# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __helper(self, root):
        stack = []
        prev = float('-inf')
        current = root
        while stack or current:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            if current.val <= prev:
                return False
            prev = current.val
            current = current.right
        return True
            
    
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.__helper(root)