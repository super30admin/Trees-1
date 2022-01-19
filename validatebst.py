# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Deque


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        stack = Deque()
        result = []

        while root != None or len(stack) != 0:

            while root != None:
                stack.append(root)
                root = root.left
                #print("root", root)

            root = stack.pop()
            if len(result) > 0:

                if root.val <= result[-1]:
                    return False
                #print("root", root)
            result.append(root.val)
            root = root.right
            #print("root", root)

        return True
