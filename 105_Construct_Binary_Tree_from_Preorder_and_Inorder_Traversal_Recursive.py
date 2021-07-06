# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        # base
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        
        # body
        root = TreeNode(preorder[0])
        index = 0
        for i, val in enumerate(inorder):
            if val == root.val:
                index = i
                break
        
        pre_left = preorder[1:index+1]
        pre_right = preorder[index+1:len(preorder)]
        in_left = inorder[:index]
        in_right = inorder[index+1:len(inorder)]
        
        root.left = self.buildTree(pre_left, in_left)
        root.right = self.buildTree(pre_right, in_right)
        
        return root