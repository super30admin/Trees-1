# Did this code successfully run on Leetcode : YES

# Approach
# a node's value is restricted in a range
# node.left value range will have a max of node.val
# similarly, node.right value range will have a min of node.val
# recursive calls and all these conditions must be true for tree to be BST

# TC: O(N)
# SC: O(N)


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, -math.inf, math.inf)
        
    def helper(self, node, mi, ma):
        if not node:
            return True
        return mi < node.val < ma and self.helper(node.left, mi, node.val) and self.helper(node.right, node.val, ma)