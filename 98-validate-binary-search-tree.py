
"""
98. Validate Binary Search Tree
Medium
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

 
Example 1:


Input: root = [2,1,3]
Output: true

Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 
Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Accepted
    Time Complexity: O(n)
    Space Complexity: O(h) where h is the height of the tree
    
    Explanation: The base intuition is at any node the value of left < root < right. But that is not enough.
    So we need to keep track of the lower and upper bounds of the tree and update them as we go down.
    Bounds start with -inf and inf on the root and as we go down the tree we update the bounds based on the root.
    
    For ex:
            5
           / \
         1   7
        / \
       3   6
       
       At this point
         1 
        / \
       3   6
       
       3 < 1 < 5 -> techincally true but not a valid BST becuase the root is 5 and everythign has to be less than 5
       6 breaches this property
       That is why we need to keep track of the bounds. for this subtree the lower bound is -inf and upper bound is 5

        For the root (5): Lower Bound = -inf, Upper Bound = inf
        Left Subtree (1): Lower Bound = -inf, Upper Bound = 5
        Left Subtree (3): Lower Bound = -inf, Upper Bound = 1 (Invalid)
        Right Subtree (6): Lower Bound = 1, Upper Bound = 5 (Invalid)
        Right Subtree (7): Lower Bound = 5, Upper Bound = inf
    """
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        flag = True
        def inorder(root, lBound, rBound) -> TreeNode:
            if root is None: return True
            if not (lBound < root.val and rBound > root.val):
                return False
            left = inorder(root.left, lBound, root.val) # left subtree should be less than root || update upper bound
            right = inorder(root.right, root.val, rBound) # right subtree should be greater than root || update lower bound
            return left and right

        return inorder(root, float("-inf"), float("inf")) # start with -inf and inf as bounds
        

LeetCode(PROBLEM, Solution).check()
