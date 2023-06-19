
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.idx = 0
        self.d = {}
        for i in range(len(inorder)):
            self.d[inorder[i]] = i
        
        def helper(start, end):
            # base condition
            if start > end:
                return None
            
            # main logic
            rootVal = preorder[self.idx]
            self.idx += 1
            root = TreeNode(rootVal)
            rootIdx = self.d[rootVal]

            left = helper(start, rootIdx-1)
            right = helper(rootIdx+1, end)

            root.left = left
            root.right = right

            return root

        return helper(0, len(inorder)-1)








        
