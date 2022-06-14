# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes

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
        def checkIfValid(node, minimum, maximum):
            if not node:
                return True
            if node.val <= minimum or node.val >= maximum:
                return False
            isValidLeft = checkIfValid(node.left, minimum, node.val)
            isValidRight = checkIfValid(node.right, node.val, maximum)

            return isValidLeft and isValidRight

        return checkIfValid(root, float('-inf'), float('inf'))
