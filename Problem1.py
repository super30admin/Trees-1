# Time Complexity: O(N)
# Space Complexity: O(N)
# Leetcode all test cases passed: Yes
# Any difficulties: No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def find(node, low, high):
            if not node:
                return True
            if low is not None and low >= node.val:
                return False
            if high is not None and node.val >= high:
                return False
            return find(node.left, low, node.val) and find(node.right, node.val, high)
        return find(root, None, None)
