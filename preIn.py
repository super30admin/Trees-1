#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.iMap = dict()
        self.idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if len(preorder) == 0:
            return None
        
        for i in range(len(inorder)):
            self.iMap[inorder[i]] = i

        return self.helper(preorder, 0, len(preorder)-1)
        
    def helper(self, preorder, start, end):
        if start > end:
            return None
        
        rootVal = preorder[self.idx]
        root = TreeNode(rootVal)
        self.idx += 1
        rootIdx = self.iMap[rootVal]
        
        root.left = self.helper(preorder, start, rootIdx-1)
        root.right = self.helper(preorder, rootIdx+1, end)
        
        return root
        
        
        
        
        
        
