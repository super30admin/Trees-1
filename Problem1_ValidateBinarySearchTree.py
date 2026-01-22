# Time Complexity : O(n) where n is the number of nodes
# Space Complexity : O(h) where h is the height of the tree (recursion stack)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use recursive DFS with min and max bounds to validate each node.
# For each node, check if its value is within the valid range (min, max) based on BST property.
# Recursively validate left subtree with updated max bound and right subtree with updated min bound.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def validate(node, min_val, max_val):
            # Empty node is valid
            if not node:
                return True
            
            # Check if current node value is within bounds
            if node.val <= min_val or node.val >= max_val:
                return False
            
            # Recursively validate left and right subtrees
            # Left subtree: all values must be < node.val, so max_val becomes node.val
            # Right subtree: all values must be > node.val, so min_val becomes node.val
            return (validate(node.left, min_val, node.val) and 
                    validate(node.right, node.val, max_val))
        
        # Start with negative and positive infinity as bounds
        return validate(root, float('-inf'), float('inf'))
