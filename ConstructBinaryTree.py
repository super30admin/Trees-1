from typing import List, Optional

# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is to create the root always with first element of preorder array and then determine the left and right subtree
# using the inorder array and recursively repeat the same using subarrays of preorder and inorder

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid+1], inorder[:mid])
        root.right = self.buildTree(preorder[mid+1:], inorder[mid+1:])

        return root