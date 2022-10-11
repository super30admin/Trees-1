##Time Complexity : O(n)
##Space Complexity : O(h), h-height of the tree
##Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def valid(node, left, right):
            if not node:
                return True
            if not (node.val <right and node.val>left):
                return False
            return(valid(node.left, left, node.val) and valid(node.right, node.val, right))
        return valid(root, float("-inf"), float("inf"))