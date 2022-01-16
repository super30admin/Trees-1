'''
TC: O(n)
SC: O(h) - height of tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if not preorder:
            return None
        
        l = len(inorder)        
        i = 0
        
        while i < l and preorder[0] != inorder[i]:
            i += 1
        
        root = TreeNode(inorder[i])
        
        root.left = self.buildTree(preorder[1:i+1], inorder[:i])
        root.right = self.buildTree(preorder[i+1:], inorder[i+1:])
        
        return root
        