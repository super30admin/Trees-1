# https://leetcode.com/problems/validate-binary-search-tree/
# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : forgot to reinitialize the global variable to -inf
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
lastval = float('-inf')


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        global lastval
        lastval = float('-inf')
        return self.inorder(root)

    def inorder(self, node):
        global lastval
        if node is None:
            return True

        if not self.inorder(node.left):
            return False
        if node.val <= lastval:
            return False
        lastval = node.val
        if not self.inorder(node.right):
            return False
        return True