'''
98. Validate Binary Search Tree
Problem Link: https://leetcode.com/problems/validate-binary-search-tree/description/
'''

# Time Complexity : O(n) for traversing all nodes using recursion
# Space Complexity : O(h) where h is the height of the tree due to recursion stack
# Did this code successfully run on Leetcode : Yes, the code passed all test cases.
# Any problem you faced while coding this : Yes, defining helper functions for left and right subtree validation was tricky, but it helped in maintaining the range for each node.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        '''
        Intuition:
        A binary tree is a valid binary search tree if for every node:
        1. All values in the left subtree are less than the node's value.
        2. All values in the right subtree are greater than the node's value.
        3. Both left and right subtrees are valid binary search trees.
        We can use a recursive approach to check these conditions by maintaining a range for each node's value.
        Approach:
        1. Define a helper function that takes a node and the valid range for its value.
        2. If the node is None, return True (an empty tree is a valid BST).
        3. Check if the node's value is within the valid range.
        4. Recursively check the left and right subtrees with the updated valid range.
        5. Return True if both subtrees are valid, otherwise return False.
        '''
        def is_node_in_range(node, low, high):
            # Checks if the node value is between low and high (exclusive).
            return low < node.val < high

        def validate_left_subtree(node, low, high):
            # The left child must be less than the current node's value.
            return helper(node.left, low, node.val)

        def validate_right_subtree(node, low, high):
            # The right child must be greater than the current node's value.
            return helper(node.right, node.val, high)

        def helper(node, low=float('-inf'), high=float('inf')):
            if not node:
                # An empty subtree is a valid BST
                return True
            if not is_node_in_range(node, low, high):
                return False
            # Check the left and right subtrees
            return validate_left_subtree(node, low, high) and validate_right_subtree(node, low, high)
        return helper(root)