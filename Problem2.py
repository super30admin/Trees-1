# Time Complexity = O(n) | Space Complexity = O(n) + O(h) hashmap and stack space

from typing import Optional
#Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    hash_map = {}
    def buildTree(self, preorder: list[int], inorder: list[int]) -> Optional[TreeNode]:
        self.idx = 0
        for i in range(len(inorder)):
            self.hash_map[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder: list[int], start: int, end: int):
        # base case
        if start > end: return None

        root_val = preorder[self.idx]
        self.idx += 1
        root_idx = self.hash_map.get(root_val)

        root = TreeNode(root_val)
        root.left = self.helper(preorder, start, root_idx - 1)
        root.right = self.helper(preorder, root_idx + 1, end)

        return root

