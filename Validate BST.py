'''
Time Complexity: O(n) number of nodes
Space Complexity: O(n) or Height of the tree
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def validate(node, low, high):
        # Check Node
        if node == None:
            return True
        # Check Node Value
        if (low != None and node.val <= low) or (high != None and node.val >= high):
            return False

        return Solution.validate(node.right, node.val, high) and Solution.validate(node.left, low, node.val)

    def isValidBST(self, root: TreeNode) -> bool:
        return Solution.validate(root, None, None)