# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

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
        bst = []
        prev = None
        while root or bst:
            while root:
                bst.append(root)
                root = root.left
            root = bst.pop()
            if prev and (prev.val >= root.val):
                return False
            prev = root
            root = root.right
        return True