# Time Complexity : O(h) where h is equal to n as we traverse through every node to check if its valid or not.
# Space Complexity : O(n) recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is to do an inorder, pre-order or post order traversal and then at each check if it's valid or not.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root, float('-inf'), float('inf'))
        return self.flag

    def helper(self, root, minVal, maxVal):
        if root == None:
            return

        if (root.val <= minVal or root.val >= maxVal):
            self.flag = False

        self.helper(root.left, minVal, root.val)

        self.helper(root.right, root.val, maxVal)