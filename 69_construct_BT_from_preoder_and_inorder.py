# Time complexity - O(n^2) # because need to find index of inorder along with the recursion call
# Space complexity - O(n) # recursive call stack for skewed tree

# Approach - dfs - Take the first node of preorder as root of the tree, find the index of the root in 
# inorder. Perform dfs on first half of preorder and second half of inorder and assign it to root.left. 
# Perform dfs on remaining of preorder and inorder and assign it to root.right.

from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder: # here, preorder is None does not work
            return None
        
        root = TreeNode(preorder[0])
        i = inorder.index(preorder[0])

        root.left = self.buildTree(preorder[1:i+1], inorder[:i])
        root.right = self.buildTree(preorder[i+1:], inorder[i+1:])

        return root