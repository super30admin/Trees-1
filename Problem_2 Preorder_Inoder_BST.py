# Time Complexity : O(N)
# Space Complexity :    O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
# Approach: # Recursion: using hashmap to store inorder indices


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0:
            return None
        self.hashmap = {}
        self.index = 0
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
        return self.helper(preorder, 0, len(inorder) - 1)

    def helper(self, preorder, start, end):
        if start > end:
            return None
        rootval = preorder[self.index]
        root = TreeNode(rootval)
        self.index += 1
        rootindex = self.hashmap[rootval]
        root.left = self.helper(preorder, start, rootindex - 1)
        root.right = self.helper(preorder, rootindex + 1, end)
        return root