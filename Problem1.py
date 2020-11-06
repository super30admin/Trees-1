# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No




# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        def checker(root, low, high):
            if root:
                if root.val <= low or root.val >= high:
                    return False
                else:
                    return checker(root.left, low, root.val) and checker(root.right, root.val, high)
            else:
                return True

        return checker(root, float('-inf'), float('inf'))

# This is a recursive solution. Here I will iterate over each of the element of tree and will check for its value an if is out the range of the values
# in which it ahould be then it will return false otherwise it will continue on iterating. This problem can also be done iteratively using a stack.