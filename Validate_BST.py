# Approach:
# Perform an in-order traversal of the tree, as it should produce a strictly increasing sequence for a valid BST.
# Keep track of the previous node's value; if any current node's value is not greater than the previous value, return False.
# This approach ensures that we check BST properties efficiently in a single in-order pass.

# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree (due to recursion stack for in-order traversal)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Initialize previous value as None for the first comparison
        self.prev = None
        
        def in_order_traverse(node):
            if not node:
                return True
            
            # Traverse left subtree
            if not in_order_traverse(node.left):
                return False
            
            # Check if current node's value is greater than the previous node's value
            if self.prev is not None and node.val <= self.prev:
                return False
            # Update previous node's value to current node's value
            self.prev = node.val
            
            # Traverse right subtree
            return in_order_traverse(node.right)
        
        # Start in-order traversal from root
        return in_order_traverse(root)
