# The code defines an isValidBST method to check if a binary tree is a valid Binary Search Tree (BST).
# In a BST, for every node, all values in its left subtree must be less than the node’s value, and all values in its right subtree must be greater.

# Helper Function:
#   - The valid function is a helper that recursively checks each node in the tree.
#   - It takes a node and a range (left, right) as arguments, where 'left' and 'right' define the valid range for the node's value.
#   
# Recursive Validation:
#   - If the node is None (base case), return True, as an empty subtree is valid.
#   - Check if the current node’s value lies within the range (left < node.val < right):
#       - If it does not, return False, as it violates the BST property.
#       - If it does, recursively check:
#           - The left subtree with an updated range where the right bound is the current node’s value.
#           - The right subtree with an updated range where the left bound is the current node’s value.
#       - The node is valid only if both recursive calls return True.

# Main Function Execution:
#   - The isValidBST function initiates the validation by calling valid on the root with an initial range of (-infinity, infinity), allowing any value for the root.
#   - The function returns True if the entire tree is a valid BST; otherwise, it returns False.

# TC: O(n) - Each node is visited once, making the time complexity linear with the number of nodes.
# SC: O(n) - The space complexity is linear due to the recursion stack, which could go up to n levels deep in the worst case.


from typing import Optional


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def valid(node, left, right):
            if not node:
                return True
            if not (left < node.val < right):
                return False

            return valid(node.left, left, node.val) and valid(
                node.right, node.val, right
            )

        return valid(root, float("-inf"), float("inf"))