#Time Complexity: O(n) Each Node is visited only once
#Space Complexity: O(h) Height of the tree dure recurssive call stack
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(node, min_value, max_value):
            if not node:
                return True
            if not min_value < node.val < max_value:
                return False
            return (helper(node.left, min_value, node.val) and helper(node.right, node.val, max_value))
        return helper(root, float('-inf'), float('inf'))