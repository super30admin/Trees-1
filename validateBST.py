# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(h), where h is the height of the tree due to recursion stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # I use a helper function with range limits to validate each node
        def validate(node, low, high):
            if not node:
                return True
            if not (low < node.val < high):
                return False
            # Left must be less than current node, right must be greater
            return validate(node.left, low, node.val) and validate(node.right, node.val, high)

        return validate(root, float('-inf'), float('inf'))
