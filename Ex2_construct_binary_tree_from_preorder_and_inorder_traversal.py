# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), for the hashmap and recursion stack in the worst case
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        # Optimized Approach using hashmap to store inorder indices
        indices = {}

        for idx, val in enumerate(inorder):
            indices[val] = idx

        self.pre_idx = 0

        def dfs(l, r):

            # Base case: if the current inorder range is invalid
            if l > r:
                return None
            
            # Pick the current root from preorder traversal
            root_val = preorder[self.pre_idx]
            self.pre_idx += 1

            # Create the root node
            root = TreeNode(root_val)

            # Find the index of root in inorder to split left and right subtrees
            mid = indices[root_val]

            # Recursively build the left subtree using inorder[l:mid]
            root.left = dfs(l, mid-1)

            # Recursively build the right subtree using inorder[mid+1:r]
            root.right = dfs(mid+1, r)

            return root

        return dfs(0, len(inorder) - 1)


 # ---------------------------------------------------------------
        # Brute Force Approach
        # Time: O(n^2) in worst case due to repeated slicing and index lookup
        # Space: O(n^2) due to slicing and recursion stack

        # if not preorder or not inorder:
        #     return None
        #
        # root_val = preorder[0]
        # root = TreeNode(root_val)
        # mid = inorder.index(root_val)
        #
        # root.left = self.buildTree(preorder[1:1+mid], inorder[:mid])
        # root.right = self.buildTree(preorder[1+mid:], inorder[mid+1:])
        #
        # return root

        

