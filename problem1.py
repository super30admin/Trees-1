# Time Complexity : O(n)
# Space Complexity:o(n)
#  Did this code successfully run on Leetcode : Yes

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
        if root is None:
            return True

        stack1 = []
        prev = None

        while root is not None or len(stack1) != 0:
            while root is not None:
                stack1.append(root)
                root = root.left

            root = stack1.pop()
            if prev is not None and prev.val >= root.val:
                return False
            prev = root
            print(root.val)
            root = root.right

        return True
