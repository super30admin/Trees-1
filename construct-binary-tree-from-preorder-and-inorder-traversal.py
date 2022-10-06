# Time complexity: O(n)
# Space complexity: O(n)

# The code successfully ran on Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.idx = 0
        self.hashmap = {}
    
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if preorder == None or len(preorder) == 0 or len(inorder) == 0: return None
        
        for i in range(len(inorder)):
            self.hashmap[inorder[i]] = i
            
        return self.helper(preorder, inorder, 0, len(inorder) - 1)
    
    def helper(self, preorder: List[int], inorder: List[int], start: int, end: int) -> Optional[TreeNode]:
        if start > end: return None
        
        # Logic
        rootval = preorder[self.idx]
        self.idx += 1
        root = TreeNode(rootval)
        rootIdx = self.hashmap[rootval]
        
        root.left = self.helper(preorder, inorder, start, rootIdx - 1)
        root.right = self.helper(preorder, inorder, rootIdx + 1, end)
        
        return root