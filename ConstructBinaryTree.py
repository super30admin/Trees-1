# Time Complexity: O(n)
# Space Complexity: O(n) -> used for map

from typing import List

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def __init__(self):
        self.idx = 0
        self.map = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(preorder, inorder, 0, len(inorder)-1)

    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> TreeNode:
        if start > end:
            return None
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        rootIdx = self.map[rootVal]
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)
        return root