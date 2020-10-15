
"""
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        """
        Write a recursive function for traversing each and every node.
        While Traversing just check the children value with the root value.
        """
        # Run Time Complexity : O(N) => Traversing every node
        # Space Complexity: O(N) => Stack Space
        return self.helper(root, -1*sys.maxsize, sys.maxsize)
        
        
    def helper(self,root, min_value, max_value):
        # Base Case
        if not root:
            return True
        
        # for left child the max value will be root value,
        # For right child the min value will be root value
        if not (min_value < root.val < max_value):
            return False
        return self.helper(root.left, min_value, root.val) and self.helper(root.right, root.val, max_value)