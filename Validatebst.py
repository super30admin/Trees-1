# Time Complexity : O(N) where N is the number of nodes in the tree
# Space Complexity : O(h) where h is the recursion stack space maximum height of the tree 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a helper function to validate the BST.
# The helper function takes three parameters - the current node, the left boundary and the right boundary.
# If the current node is None, I am returning True.
# If the current node's value is not within the left and right boundaries, I am returning False.
# I am recursively calling the helper function for the left and right subtrees, updating the boundaries accordingly.
# Finally, I am returning the result of the helper function.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def helper(root,left,right):
            if not root:
                return True
            if not left < root.val < right:
                return False
            return helper(root.left,left,root.val) and helper(root.right,root.val,right) 
        return helper(root,float('-inf'),float('inf'))
            