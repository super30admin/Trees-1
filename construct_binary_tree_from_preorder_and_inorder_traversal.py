# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        # base case
        if not preorder or not inorder: return None
        
        if len(preorder) == 1: return TreeNode(preorder[0])
        
        root = TreeNode(preorder[0])
        root_temp = inorder.index(preorder[0])
        
        # you need to use the array to seperate between the sections to search
        root.left = self.buildTree(preorder[1: root_temp + 1], inorder[ :root_temp])
        root.right = self.buildTree(preorder[root_temp + 1:], inorder[root_temp + 1: ])
        
        return root