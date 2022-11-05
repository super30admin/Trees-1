# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree, worse case - O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import sys
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return
        
        def dfs(node, low, high):
            if node == None:
                return True
            
            if node.val<=low or node.val>=high:
                return False
            
            return (dfs(node.left, low, node.val) and dfs(node.right, node.val, high))
        
        return dfs(root, -sys.maxsize, sys.maxsize)        