# Time Complexity: O(n)
# Space Complexity: O(n) as we are storing every element in hashmap
# Ran on Leetcode: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.map = {}
        self.index = 0
        
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not len(preorder):
            return None
        for i in range(len(inorder)):
            self.map[inorder[i]] = i
        return self.helper(preorder, 0, len(preorder) - 1)
    
    def helper(self, preorder, start, end):
        if start > end:
            return None
        root = TreeNode(preorder[self.index])
        self.index += 1
        idx = self.map[root.val]
        root.left = self.helper(preorder, start , idx - 1)
        root.right = self.helper(preorder, idx + 1 , end)
        return root
        